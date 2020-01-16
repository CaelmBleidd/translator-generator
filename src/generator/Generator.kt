package generator

import EOF
import EPS
import MyGrammarVisitor
import java.io.File
import kotlin.text.Typography.dollar

private val SEPARATOR: String = System.lineSeparator()

const val DIR = "test/generated"

fun generateFiles(visitors: Array<MyGrammarVisitor>, prefixes: Array<String> = arrayOf("")) {
    File(DIR).deleteRecursively()
    File(DIR).mkdir()

    for ((i, prefix) in prefixes.withIndex()) {
        var path = DIR
        if (prefix.isNotEmpty()) {
            val pack = prefix.substringBefore("Grammar")
            path += "/$pack"
            File(path).mkdir()
        }
        val packageHeader = "package ${path.substringAfter("test/").replace("/", ".")}\n"
        val visitor = visitors[i]
        File("$path/Token.kt").writeText(packageHeader + SEPARATOR + generateToken(visitor))
        File("$path/Node.kt").writeText(packageHeader + SEPARATOR + generateNode(visitor))
        File("$path/Lexer.kt").writeText(packageHeader + SEPARATOR + generateLexer(visitor))
        File("$path/Parser.kt").writeText(packageHeader + SEPARATOR + generateParser(visitor))
    }
}

fun generateNode(visitor: MyGrammarVisitor) =
        """
        data class Node(val name: String, val children: List<Node?> = arrayListOf()) {
            ${visitor.nodes.trim()}
        }
        """.trimIndent()


fun generateToken(visitor: MyGrammarVisitor) = buildString {
    append("enum class Token {\n")
    val tokens = arrayListOf<String>()
    for (token in visitor.tokens.keys) {
        tokens.add("\t$token")
    }
    append(tokens.joinToString(",\n"))
    append("\n}")
}

fun generateLexer(visitor: MyGrammarVisitor) = buildString {
    append(
            """
            import java.io.IOException
            import java.io.Reader
            import java.text.ParseException
            
            class Lexer(private val stream: Reader) {
                constructor(s: String) : this(s.reader())
                
                var curPos = -1
                var curChar = -1
                var token: Token = Token.EOF
                var tokenValue = ""
                val tokenText = StringBuilder()
            
                init {
                    nextChar()
                    nextToken()
                }
            
                private fun isBlank(c: Char): Boolean {
                    return c == ' ' || c == '\r' || c == '\t' || c == '\n'
                }
            
                private fun nextChar() {
                    try {
                        curChar = stream.read()
                    } catch (e: IOException) {
                        throw ParseException(e.message, curPos + 1)
                    } finally {
                        ++curPos
                    }
                }
                
                fun nextToken() {
                    while (isBlank(curChar.toChar())) {
                        nextChar()
                    }
                    var toString = ""
                    var last: Char
            
                    while (!isBlank(curChar.toChar())) {
                        if (curChar == -1) {
                            toString = tokenText.toString();
                            tokenText.clear()
                            token = Token.EOF
                            tokenValue = "EOF"
                            break;
                        }
                        last = curChar.toChar()
                        toString = tokenText.toString()
                        tokenText.append(curChar.toChar())
                        val isToken = ${visitor.tokens.values.joinToString(separator = " || ")
            { s -> "tokenText.matches(\"$s\".toRegex())" }}
            
                        if (isToken) {
                            nextChar()
                            if (isBlank(curChar.toChar()) || curChar == -1) {
                                toString = tokenText.toString()
                                tokenText.clear()
                                break
                            }
                        } else {
                            tokenText.clear()
                            tokenText.append(last)
                            nextChar()
                            break
                        }
                    }
                    
        """.trimIndent()
    )

    for (token in visitor.tokens.keys) {
        if (token == "EPS") {
            continue
        }

        append(
"""
        if (toString.matches("${visitor.tokens[token]}".toRegex())) {
            token = Token.$token
            tokenValue = toString
            return
        }
"""
        )
    }
    append(
            """
                }
            }
            """.trimIndent()
    )
}

fun generateParser(visitor: MyGrammarVisitor) = buildString {
    append(
"""
import java.text.ParseException
import java.util.ArrayDeque

class Parser {
    lateinit var lexer: Lexer
    var text = ""
    ${visitor.attributes.trim()}
    
    private fun unexpectedLiteral(rule: String): Nothing = throw ParseException(
        "Unexpected literal ${dollar}{lexer.tokenValue} in rule ${dollar}{lexer.curPos}", lexer.curPos
    )
    
    private fun check(token: Token, rule: String) {
        if (lexer.token != token) {
            unexpectedLiteral(rule)
        }
    }
"""
    )
    append(SEPARATOR)

    for (ruleName in visitor.rules.keys) {
        append(
"""
    private fun ${ruleName}(): Node {
        val children = arrayListOf<Node>()
        val res = Node("$ruleName", children)
        
        when (lexer.token) {
"""
        )

        for (firstToken in visitor.first[ruleName]!!) {
            var varIndex = 0
            val ruleNumber = visitor.ruleNumberFromFirst[ruleName]!![firstToken]!!
            if (firstToken == EPS) {
                for (ruleFollow in visitor.follow[ruleName]!!) {
                    append(addTabs(3))
                    append("Token.$ruleFollow -> {")
                    append(SEPARATOR)
                    for (rulePart in visitor.rules[ruleName]!![ruleNumber]) {
                        if (rulePart.startsWith('$')) {
                            append(addTabs(4) + rulePart.substring(1, rulePart.lastIndex)
                                    .split(";")
                                    .map { it.trim() }
                                    .joinToString("\n" + addTabs(4))
                                    .trim() + SEPARATOR)
                        }
                    }
                    append(addTabs(4))
                    append("children.add(Node(\"EPS\"))")
                    append(SEPARATOR)
                    append(addTabs(4))
                    append("return res")
                    append(SEPARATOR)
                    append(addTabs(3) + "}")
                    append(SEPARATOR)
                }
                continue
            }
            append(addTabs(3))
            append("Token.$firstToken -> {")
            append(SEPARATOR)
            for (rulePart in visitor.rules[ruleName]!![ruleNumber]) {
                if (rulePart.startsWith('$')) {
                    append(addTabs(4) + rulePart.substring(1, rulePart.lastIndex)
                            .split(";")
                            .map { it.trim() }
                            .joinToString("\n" + addTabs(4))
                            .trim() + SEPARATOR)
                    continue
                }
                if (rulePart in visitor.tokens.keys) {
                    append(addTabs(4))
                    append("check(Token.${rulePart}, \"$rulePart\")")
                    append(SEPARATOR)
                    append(addTabs(4))
                    append("text = lexer.tokenValue")
                    append(SEPARATOR)
                    append(addTabs(4))
                    if (rulePart == EOF) {
                        append("children.add(Node(\"EOF\"))")
                    } else {
                        append("children.add(Node(text))")
                    }
                    append(SEPARATOR + SEPARATOR)
                    append(addTabs(4))
                    append("lexer.nextToken()")
                    append(SEPARATOR + SEPARATOR)
                } else {
                    append(addTabs(4))
                    append("val var$varIndex = $rulePart()")
                    append(SEPARATOR)
                    append(addTabs(4))
                    append("children.add(var$varIndex)")
                    append(SEPARATOR + SEPARATOR)
                    ++varIndex
                }
            }
            append(addTabs(4))
            append("return res")
            append(SEPARATOR)
            append(addTabs(3))
            append("}")
            append(SEPARATOR)
        }
        append(addTabs(3))
        append("else -> {")
        append(SEPARATOR + addTabs(4))
        append("unexpectedLiteral(\"${ruleName}\")")
        append(SEPARATOR + addTabs(3) + "}" + SEPARATOR + addTabs(2) + "}" + SEPARATOR + addTabs(1) + "}" + SEPARATOR)
    }

    append(
            """
                fun parse(input: String): Node {
                    lexer = Lexer(input)
                    return start()
                }
            }
            """.trimIndent()
    )
}

private fun addTabs(value: Int) = "    ".repeat(value)
