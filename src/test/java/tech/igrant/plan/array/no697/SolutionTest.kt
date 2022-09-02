package tech.igrant.plan.array.no697

import org.junit.Test

import org.junit.Assert.*
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(intArrayOf(1), 1),
            TestCase(intArrayOf(1, 2, 2, 3, 1, 4, 2), 6),
            TestCase(intArrayOf(1, 2, 2, 3, 1), 2),
    )

    val solution = Solution()

    @Test
    fun findShortestSubArray() {
        for (testCase in testCases) {
            JSON.printJSONALine(testCase)
            val act = solution.findShortestSubArray(testCase.nums)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }

}