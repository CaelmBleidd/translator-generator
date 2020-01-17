package generated.pascalToC


import java.text.ParseException
import java.util.ArrayDeque

class Parser {
    lateinit var lexer: Lexer
    var text = ""
    var variables = StringBuilder()
    
    private fun unexpectedLiteral(rule: String): Nothing = throw ParseException(
        "Unexpected literal ${lexer.tokenValue} in rule ${lexer.curPos}", lexer.curPos
    )
    
    private fun check(token: Token, rule: String) {
        if (lexer.token != token) {
            unexpectedLiteral(rule)
        }
    }


    private fun args(): Node {
        val children = arrayListOf<Node>()
        val res = Node("args", children)
        
        when (lexer.token) {
            Token.IDENT -> {
                val var0 = names()
                children.add(var0)

                check(Token.COLON, "COLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var1 = type()
                children.add(var1)

                for (variable in var0.value.split(" ")) variables.append(variable + ' ' + var1.value + '\n')
                val var2 = argsPrime()
                children.add(var2)

                return res
            }
            Token.RPAREN -> {
                children.add(Node("EPS"))
                return res
            }
            else -> {
                unexpectedLiteral("args")
            }
        }
    }

    private fun names(): Node {
        val children = arrayListOf<Node>()
        val res = Node("names", children)
        
        when (lexer.token) {
            Token.IDENT -> {
                check(Token.IDENT, "IDENT")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text + ' '
                val var0 = namesPrime()
                children.add(var0)

                res.value += var0.value
                return res
            }
            else -> {
                unexpectedLiteral("names")
            }
        }
    }

    private fun signature(): Node {
        val children = arrayListOf<Node>()
        val res = Node("signature", children)
        
        when (lexer.token) {
            Token.PROCEDURE -> {
                check(Token.PROCEDURE, "PROCEDURE")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.IDENT, "IDENT")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.LPAREN, "LPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = args()
                children.add(var0)

                check(Token.RPAREN, "RPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.SEMICOLON, "SEMICOLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                return res
            }
            Token.FUNCTION -> {
                check(Token.FUNCTION, "FUNCTION")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.IDENT, "IDENT")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.LPAREN, "LPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = args()
                children.add(var0)

                check(Token.RPAREN, "RPAREN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.COLON, "COLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var1 = type()
                children.add(var1)

                check(Token.SEMICOLON, "SEMICOLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                return res
            }
            else -> {
                unexpectedLiteral("signature")
            }
        }
    }

    private fun start(): Node {
        val children = arrayListOf<Node>()
        val res = Node("start", children)
        
        when (lexer.token) {
            Token.PROCEDURE -> {
                val var0 = signature()
                children.add(var0)

                res.value = var0.value
                check(Token.EOF, "EOF")
                text = lexer.tokenValue
                children.add(Node("EOF"))

                lexer.nextToken()

                return res
            }
            Token.FUNCTION -> {
                val var0 = signature()
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

    private fun namesPrime(): Node {
        val children = arrayListOf<Node>()
        val res = Node("namesPrime", children)
        
        when (lexer.token) {
            Token.COMMA -> {
                check(Token.COMMA, "COMMA")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                check(Token.IDENT, "IDENT")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text + ' '
                val var0 = namesPrime()
                children.add(var0)

                res.value += var0.value
                return res
            }
            Token.COLON -> {
                res.value = ""
                children.add(Node("EPS"))
                return res
            }
            else -> {
                unexpectedLiteral("namesPrime")
            }
        }
    }

    private fun type(): Node {
        val children = arrayListOf<Node>()
        val res = Node("type", children)
        
        when (lexer.token) {
            Token.TYPE_CHAR -> {
                check(Token.TYPE_CHAR, "TYPE_CHAR")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text
                return res
            }
            Token.TYPE_STRING -> {
                check(Token.TYPE_STRING, "TYPE_STRING")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text
                return res
            }
            Token.TYPE_INTEGER -> {
                check(Token.TYPE_INTEGER, "TYPE_INTEGER")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text
                return res
            }
            Token.TYPE_BOOLEAN -> {
                check(Token.TYPE_BOOLEAN, "TYPE_BOOLEAN")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text
                return res
            }
            Token.TYPE_REAL -> {
                check(Token.TYPE_REAL, "TYPE_REAL")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                res.value = text
                return res
            }
            else -> {
                unexpectedLiteral("type")
            }
        }
    }

    private fun argsPrime(): Node {
        val children = arrayListOf<Node>()
        val res = Node("argsPrime", children)
        
        when (lexer.token) {
            Token.SEMICOLON -> {
                check(Token.SEMICOLON, "SEMICOLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var0 = names()
                children.add(var0)

                check(Token.COLON, "COLON")
                text = lexer.tokenValue
                children.add(Node(text))

                lexer.nextToken()

                val var1 = type()
                children.add(var1)

                for (variable in var0.value.split(" ")) variables.append(variable + ' ' + var1.value + '\n')
                val var2 = argsPrime()
                children.add(var2)

                return res
            }
            Token.RPAREN -> {
                children.add(Node("EPS"))
                return res
            }
            else -> {
                unexpectedLiteral("argsPrime")
            }
        }
    }
    fun parse(input: String): Node {
        lexer = Lexer(input)
        return start()
    }
}