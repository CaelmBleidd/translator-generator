package testSets

import org.junit.Test
import generated.pascalToC.Parser

class PascalToCTest {
    private val parser by lazy {
        Parser()
    }

    @Test
    fun correctWithDraw() {
        val input = "function parse(a, b: integer; c, d: char): boolean;"
        TreeDrawer().printToFile(parser.parse(input), "autoTest")
        Runtime.getRuntime().exec("dot -Tjpg autoTest.dot -o autoTest.jpg")
    }

}