package tech.igrant.daily.no646

import org.junit.Assert.assertEquals
import org.junit.Test
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(val pairs: Array<IntArray>, val exp: Int)

    val testCases = listOf(
            TestCase(
                    arrayOf(
                            intArrayOf(-10, -8),
                            intArrayOf(8, 9),
                            intArrayOf(-5, 0),
                            intArrayOf(6, 10),
                            intArrayOf(-6, -4),
                            intArrayOf(1, 7),
                            intArrayOf(9, 10),
                            intArrayOf(-4, 7)
                    ),
                    4
            ),
            TestCase(
                    arrayOf(
                            intArrayOf(1, 2),
                            intArrayOf(2, 3),
                            intArrayOf(3, 4),
                    ),
                    2
            ),
            TestCase(
                    arrayOf(
                            intArrayOf(1, 3),
                            intArrayOf(11, 15),
                            intArrayOf(4, 8),
                    ),
                    3
            ),
            TestCase(
                    arrayOf(
                            intArrayOf(1, 5),
                            intArrayOf(11, 15),
                            intArrayOf(4, 8),
                    ),
                    2
            ),
    )

    val solution = Solution()

    @Test
    fun findLongestChain() {
        for (testCase in testCases) {
            JSON.printJSONALine(testCase)
            val act = solution.findLongestChain(testCase.pairs)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }

    @Test
    fun findLongestChain1() {
        val res = ClassLoader.getSystemClassLoader().getResource("no646/testcase.json")
        val pairs = JSON.readTo(res, IntArray::class.java).filterNotNull().toTypedArray()
        println(pairs.size)
        val actual = solution.findLongestChain(pairs)
        assertEquals(
                38,
                actual
        )
    }

}