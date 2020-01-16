import generated.GrammarTemplateBaseVisitor
import generated.GrammarTemplateParser

const val START = "start"
const val EOF = "EOF"
const val EPS = "EPS"

class MyGrammarVisitor : GrammarTemplateBaseVisitor<String>() {

    var attributes = ""
    var nodes = ""

    val rules = hashMapOf<String, ArrayList<ArrayList<String>>>()
    val tokens = linkedMapOf<String, String>()

    val first = hashMapOf<String, HashSet<String>>()
    val follow = hashMapOf<String, HashSet<String>>()

    val ruleNumberFromFirst = hashMapOf<String, HashMap<String, Int>>()

    //    file : (attributes)  (nodeValues) myRules myTokens EOF;
    override fun visitFile(ctx: GrammarTemplateParser.FileContext): String {
        for (child in ctx.children) {
            visit(child)
        }

        constructFirst()
        constructFollow()
        buildRuleNumberFromFirst()

        return ""
    }

    private fun getFirst(s: String): HashSet<String> {
        if (s in tokens) {
            return hashSetOf(s)
        }
        return if (s in first) {
            HashSet(first[s]!!)
        } else {
            hashSetOf()
        }
    }

    private fun constructFirst() {
        for (key in rules.keys) {
            first[key] = hashSetOf()
        }

        var changed = true
        while (changed) {
            changed = false
            for (key in rules.keys) {
                for (rule in rules[key]!!) {
                    val firstItem = getFirst(rule.first())
                    val prevSize = first[key]!!.size
                    first[key]!!.addAll(firstItem)
                    if (first[key]!!.size != prevSize) {
                        changed = true
                    }
                }
            }
        }
    }

    private fun getFollow(s: String) = if (s in follow.keys) HashSet(follow[s]!!) else hashSetOf()

    private fun constructFollow() {
        for (key in rules.keys) {
            follow[key] = hashSetOf()
        }

        follow[START] = hashSetOf(EOF)
        var changed = true

        while (changed) {
            changed = false
            for (key in rules.keys) {
                for (rule in rules[key]!!) {
                    for (i in rule.indices) {
                        if (rule[i].startsWith("$") || rule[i] !in rules) {
                            continue
                        }
                        if (i < rule.size - 1) {
                            var position = i + 1
                            while (position < rule.size && rule[position].startsWith("$")) {
                                position++
                            }
                            if (position >= rule.size) {
                                val parentFollow = getFollow(key)
                                val prevSize = follow[rule[i]]!!.size
                                follow[rule[i]]!!.addAll(parentFollow)
                                if (follow[rule[i]]!!.size != prevSize) {
                                    changed = true
                                }
                                continue
                            }
                            val nextFirst = getFirst(rule[position])
                            if (nextFirst.contains(EPS)) {
                                nextFirst.remove(EPS)
                                val nextFollow = getFollow(rule[position])
                                val prevSize = follow[rule[i]]!!.size
                                follow[rule[i]]!!.addAll(nextFollow)
                                if (follow[rule[i]]!!.size != prevSize) {
                                    changed = true
                                }
                            }

                            val prevSize = follow[rule[i]]!!.size
                            follow[rule[i]]!!.addAll(nextFirst)
                            if (follow[rule[i]]!!.size != prevSize) {
                                changed = true
                            }
                        } else {
                            val parentFollow = getFollow(key)
                            val prevSize = follow[rule[i]]!!.size
                            follow[rule[i]]!!.addAll(parentFollow)
                            if (follow[rule[i]]!!.size != prevSize) {
                                changed = true
                            }
                        }
                    }
                }
            }
        }
    }

    private fun buildRuleNumberFromFirst() {
        for (ruleName in first.keys) {
            ruleNumberFromFirst[ruleName] = hashMapOf()
            for (firstElement in first[ruleName]!!) {
                for (i in rules[ruleName]!!.indices) {
                    if (firstElement in getFirst(rules[ruleName]!![i][0])) {
                        val tokenToRule = ruleNumberFromFirst[ruleName]!!
                        tokenToRule[firstElement] = i
                    }
                }
            }
        }
    }

    override fun visitAttributes(ctx: GrammarTemplateParser.AttributesContext): String {
        attributes = ctx.getChild(1).text
        attributes = attributes.substring(1, attributes.lastIndex)
        return ""
    }

    override fun visitNodeValues(ctx: GrammarTemplateParser.NodeValuesContext): String {
        nodes = ctx.getChild(1).text
        nodes = nodes.substring(1, nodes.lastIndex)
        return ""
    }

    //    myRules : (myRule)+;
    override fun visitMyRules(ctx: GrammarTemplateParser.MyRulesContext): String {
        for (child in ctx.children) {
            visit(child)
        }
        return ""
    }

    //    myRule : RULE_NAME ARROW (RULE_NAME | TOKEN_NAME | SEMANTIC_RULE)+ SEMICOLON;
    override fun visitMyRule(ctx: GrammarTemplateParser.MyRuleContext): String {
        val ruleName = ctx.getChild(0).text
        val rule = arrayListOf<String>()
        for (i in 2 until ctx.childCount - 1) {
            rule.add(ctx.getChild(i).text)
        }
        rules.putIfAbsent(ruleName, arrayListOf())
        rules[ruleName]!!.add(rule)
        return ""
    }

    //    myTokens : (myToken)+;
    override fun visitMyTokens(ctx: GrammarTemplateParser.MyTokensContext): String {
        for (child in ctx.children) {
            visit(child)
        }
        return ""
    }

    //    myToken : TOKEN_NAME ARROW LITERAL SEMICOLON;
    override fun visitMyToken(ctx: GrammarTemplateParser.MyTokenContext): String {
        val tokenName = ctx.getChild(0).text
        var value = ctx.getChild(2).text
        value = value.substring(1, value.lastIndex)
        tokens[tokenName] = value
        return ""
    }


}