package testSets

import org.junit.Assert.assertEquals
import org.junit.Test
import generated.calculator.Parser


class CalculatorTest {
    private val parser by lazy {
        Parser()
    }

    @Test
    fun calculatorTest() {
        val expressions = arrayOf("2 + 2 * 2", "1 + 2 * 3 + 4 - 5", "(1 + 2) * (-(3) * (7 - 4) + 2)", "1 - 2 - 3")
        val answers = arrayOf("6", "6", "-21", "-4")
        for (i in expressions.indices) {
            val node = parser.parse(expressions[i])
            val curAns = "${node.value}"
            println("${expressions[i]} = $curAns")
            assertEquals(curAns, answers[i])
        }
        println("=".repeat(40))
    }
}