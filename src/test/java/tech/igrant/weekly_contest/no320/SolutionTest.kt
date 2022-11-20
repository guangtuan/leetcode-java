package tech.igrant.weekly_contest.no320

import org.junit.Assert
import org.junit.Test

class SolutionTest {

    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(
                    nums = intArrayOf(4, 4, 2, 4, 3),
                    exp = 3
            )
    )

    val solution = Solution()

    @Test
    fun test() {
        for (testCase in testCases) {
            Assert.assertEquals(
                    testCase.exp,
                    solution.unequalTriplets(testCase.nums)
            )
        }
    }

}