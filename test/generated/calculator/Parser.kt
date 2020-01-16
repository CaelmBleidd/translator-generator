package generated.calculator


import java.text.ParseException
import java.util.ArrayDeque

class Parser {
    lateinit var lexer: Lexer
    var text = ""
    val stack = ArrayDeque<Long>();

    private fun unexpectedLiteral(rule: String): Nothing = throw ParseException(
            "Unexpected literal ${lexer.tokenValue} in rule ${lexer.curPos}", lexer.curPos
    )

    private fun check(token: Token, rule: String) {
        if (lexer.token != token) {
            unexpectedLiteral(rule)
        }
    }


    private fun number(): Node {
        val children = arrayListOf<Node>()
        val res = Node("number", children)

        when (lexer.token) {
            Token.NUMBER -> {
                check(Token.NUMBER, "NUMBER")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                return res
            }
            else -> {
                unexpectedLiteral("number")
            }
        }
    }

    private fun fullGrammar(): Node {
        val children = arrayListOf<Node>()
        val res = Node("fullGrammar", children)

        when (lexer.token) {
            Token.NUMBER -> {
                val var0 = expression()
                children.add(var0)

                res.value = var0.value
                return res
            }
            Token.LPAREN -> {
                val var0 = expression()
                children.add(var0)

                res.value = var0.value
                return res
            }
            Token.MINUS -> {
                val var0 = expression()
                children.add(var0)

                res.value = var0.value
                return res
            }
            else -> {
                unexpectedLiteral("fullGrammar")
            }
        }
    }

    private fun expression(): Node {
        val children = arrayListOf<Node>()
        val res = Node("expression", children)

        when (lexer.token) {
            Token.NUMBER -> {
                val var0 = term()
                children.add(var0)

                val var1 = expressionPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.LPAREN -> {
                val var0 = term()
                children.add(var0)

                val var1 = expressionPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.MINUS -> {
                val var0 = term()
                children.add(var0)

                val var1 = expressionPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            else -> {
                unexpectedLiteral("expression")
            }
        }
    }

    private fun exprInBrackets(): Node {
        val children = arrayListOf<Node>()
        val res = Node("exprInBrackets", children)

        when (lexer.token) {
            Token.LPAREN -> {
                check(Token.LPAREN, "LPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = expression()
                children.add(var0)

                check(Token.RPAREN, "RPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = var0.value
                return res
            }
            else -> {
                unexpectedLiteral("exprInBrackets")
            }
        }
    }

    private fun start(): Node {
        val children = arrayListOf<Node>()
        val res = Node("start", children)

        when (lexer.token) {
            Token.NUMBER -> {
                val var0 = fullGrammar()
                children.add(var0)

                res.value = var0.value
                check(Token.EOF, "EOF")
                text = lexer.tokenValue
                children.add(Node("EOF"))

                lexer.nextToken()

                return res
            }
            Token.LPAREN -> {
                val var0 = fullGrammar()
                children.add(var0)

                res.value = var0.value
                check(Token.EOF, "EOF")
                text = lexer.tokenValue
                children.add(Node("EOF"))

                lexer.nextToken()

                return res
            }
            Token.MINUS -> {
                val var0 = fullGrammar()
                children.add(var0)

                res.value = var0.value
                check(Token.EOF, "EOF")
                text = lexer.tokenValue
                children.add(Node("EOF"))

                lexer.nextToken()

                return res
            }
            else -> {
                unexpectedLiteral("start")
            }
        }
    }

    private fun expressionPrime(): Node {
        val children = arrayListOf<Node>()
        val res = Node("expressionPrime", children)

        when (lexer.token) {
            Token.RPAREN -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            Token.EOF -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            Token.MINUS -> {
                check(Token.MINUS, "MINUS")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = term()
                children.add(var0)

                val second = stack.pollLast()
                val first = stack.pollLast()
                stack.addLast(first - second)
                val var1 = expressionPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.PLUS -> {
                check(Token.PLUS, "PLUS")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = term()
                children.add(var0)

                val second = stack.pollLast()
                val first = stack.pollLast()
                stack.addLast(first + second)
                val var1 = expressionPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            else -> {
                unexpectedLiteral("expressionPrime")
            }
        }
    }

    private fun term(): Node {
        val children = arrayListOf<Node>()
        val res = Node("term", children)

        when (lexer.token) {
            Token.NUMBER -> {
                val var0 = factor()
                children.add(var0)

                val var1 = termPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.LPAREN -> {
                val var0 = factor()
                children.add(var0)

                val var1 = termPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.MINUS -> {
                val var0 = factor()
                children.add(var0)

                val var1 = termPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            else -> {
                unexpectedLiteral("term")
            }
        }
    }

    private fun factor(): Node {
        val children = arrayListOf<Node>()
        val res = Node("factor", children)

        when (lexer.token) {
            Token.NUMBER -> {
                val var0 = number()
                children.add(var0)

                res.value = text.toLong()
                stack.addLast(text.toLong())
                return res
            }
            Token.LPAREN -> {
                val var0 = exprInBrackets()
                children.add(var0)

                return res
            }
            Token.MINUS -> {
                check(Token.MINUS, "MINUS")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = exprInBrackets()
                children.add(var0)

                res.value = -var0.value
                stack.pollLast()
                stack.addLast(res.value)
                return res
            }
            else -> {
                unexpectedLiteral("factor")
            }
        }
    }

    private fun termPrime(): Node {
        val children = arrayListOf<Node>()
        val res = Node("termPrime", children)

        when (lexer.token) {
            Token.MUL -> {
                check(Token.MUL, "MUL")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = factor()
                children.add(var0)

                val second = stack.pollLast()
                val first = stack.pollLast()
                stack.addLast(first * second)
                val var1 = termPrime()
                children.add(var1)

                res.value = var1.value
                return res
            }
            Token.RPAREN -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            Token.EOF -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            Token.MINUS -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            Token.PLUS -> {
                res.value = stack.peekLast()
                children.add(Node("EPS"))
                return res
            }
            else -> {
                unexpectedLiteral("termPrime")
            }
        }
    }

    fun parse(input: String): Node {
        lexer = Lexer(input)
        return start()
    }
}