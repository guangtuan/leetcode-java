package tech.igrant.daily.no1582

import org.junit.Test

import org.junit.Assert.*
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(val exp: Int, val mat: Array<IntArray>)

    val testCases = listOf(
            TestCase(1, arrayOf(
                    intArrayOf(0, 0, 0, 0, 0, 1, 0, 0),
                    intArrayOf(0, 0, 0, 0, 1, 0, 0, 1),
                    intArrayOf(0, 0, 0, 0, 1, 0, 0, 0),
                    intArrayOf(1, 0, 0, 0, 1, 0, 0, 0),
                    intArrayOf(0, 0, 1, 1, 0, 0, 0, 0)
            ))
    )

    val solution = Solution()

    @Test
    fun numSpecial() {
        for (testCase in testCases) {
            JSON.printJSONALine(testCase)
            val act = solution.numSpecial(testCase.mat)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}