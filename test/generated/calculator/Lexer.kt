package generated.calculator

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
            val isToken = tokenText.matches("\\+".toRegex()) || tokenText.matches("\\-".toRegex()) || tokenText.matches("\\*".toRegex()) || tokenText.matches("[0-9]+".toRegex()) || tokenText.matches("\\(".toRegex()) || tokenText.matches("\\)".toRegex()) || tokenText.matches("EPS".toRegex()) || tokenText.matches("\\$".toRegex())

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
        
        if (toString.matches("\\+".toRegex())) {
            token = Token.PLUS
            tokenValue = toString
            return
        }

        if (toString.matches("\\-".toRegex())) {
            token = Token.MINUS
            tokenValue = toString
            return
        }

        if (toString.matches("\\*".toRegex())) {
            token = Token.MUL
            tokenValue = toString
            return
        }

        if (toString.matches("[0-9]+".toRegex())) {
            token = Token.NUMBER
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

        if (toString.matches("\\$".toRegex())) {
            token = Token.EOF
            tokenValue = toString
            return
        }
    }
}