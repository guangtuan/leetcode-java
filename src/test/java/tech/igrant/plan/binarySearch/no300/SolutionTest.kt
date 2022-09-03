package tech.igrant.plan.binarySearch.no300

import org.junit.Test
import tech.igrant.support.JSON
import kotlin.test.assertEquals

class SolutionTest {

    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6), 6),
            TestCase(intArrayOf(4, 10, 4, 3, 8, 9), 3)
    )

    val solution = Solution()

    @Test
    fun lengthOfLIS() {
        for (testCase in testCases) {
            JSON.printJSONALine(testCase)
            val act = solution.lengthOfLIS(testCase.nums)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}