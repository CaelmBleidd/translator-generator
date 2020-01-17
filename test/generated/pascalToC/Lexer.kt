package generated.pascalToC

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
            val isToken = tokenText.matches("function".toRegex()) || tokenText.matches("procedure".toRegex()) || tokenText.matches("integer".toRegex()) || tokenText.matches("char".toRegex()) || tokenText.matches("real".toRegex()) || tokenText.matches("boolean".toRegex()) || tokenText.matches("string".toRegex()) || tokenText.matches("\\(".toRegex()) || tokenText.matches("\\)".toRegex()) || tokenText.matches(",".toRegex()) || tokenText.matches(":".toRegex()) || tokenText.matches(";".toRegex()) || tokenText.matches("[a-zA-Z_][a-zA-Z_0-9]*".toRegex()) || tokenText.matches("eps".toRegex()) || tokenText.matches("\\$".toRegex())

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
        
        if (toString.matches("function".toRegex())) {
            token = Token.FUNCTION
            tokenValue = toString
            return
        }

        if (toString.matches("procedure".toRegex())) {
            token = Token.PROCEDURE
            tokenValue = toString
            return
        }

        if (toString.matches("integer".toRegex())) {
            token = Token.TYPE_INTEGER
            tokenValue = toString
            return
        }

        if (toString.matches("char".toRegex())) {
            token = Token.TYPE_CHAR
            tokenValue = toString
            return
        }

        if (toString.matches("real".toRegex())) {
            token = Token.TYPE_REAL
            tokenValue = toString
            return
        }

        if (toString.matches("boolean".toRegex())) {
            token = Token.TYPE_BOOLEAN
            tokenValue = toString
            return
        }

        if (toString.matches("string".toRegex())) {
            token = Token.TYPE_STRING
            tokenValue = toString
            return
        }

        if (toString.matches("\\(".toRegex())) {
            token = Token.LPAREN
            tokenValue = toString
            return
        }

        if (toString.matches("\\)".toRegex())) {
            token = Token.RPAREN
            tokenValue = toString
            return
        }

        if (toString.matches(",".toRegex())) {
            token = Token.COMMA
            tokenValue = toString
            return
        }

        if (toString.matches(":".toRegex())) {
            token = Token.COLON
            tokenValue = toString
            return
        }

        if (toString.matches(";".toRegex())) {
            token = Token.SEMICOLON
            tokenValue = toString
            return
        }

        if (toString.matches("[a-zA-Z_][a-zA-Z_0-9]*".toRegex())) {
            token = Token.IDENT
            tokenValue = toString
            return
        }

        if (toString.matches("\\$".toRegex())) {
            token = Token.EOF
            tokenValue = toString
            return
        }
    }
}