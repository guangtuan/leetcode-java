package tech.igrant.weekly_contest.no316.no2

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val k: Int, val exp: Int)

    val testCases = listOf(
            TestCase(
                    nums = intArrayOf(4, 3, 1, 3, 3),
                    k = 1,
                    exp = 10
            ),
            TestCase(
                    nums = intArrayOf(1, 1, 4, 1),
                    k = 3,
                    exp = 0
            ),
            TestCase(
                    nums = intArrayOf(1, 5, 3, 2, 3),
                    k = 2,
                    exp = 1
            ),
            TestCase(
                    nums = intArrayOf(3, 12, 9, 6),
                    k = 3,
                    exp = 7
            ),
            TestCase(
                    nums = intArrayOf(9, 3, 1, 2, 6, 3), k = 3, exp = 4
            ),
            TestCase(
                    nums = intArrayOf(4), k = 7, exp = 0
            ),
            TestCase(
                    nums = intArrayOf(1), k = 1, exp = 1
            ),
            TestCase(
                    nums = intArrayOf(5), k = 1, exp = 0
            ),
    )

    val solution = Solution()

    @Test
    fun subarrayGCD() {
        for (testCase in testCases) {
            val actual = solution.subarrayGCD(testCase.nums, testCase.k)
            assertEquals(
                    testCase.exp,
                    actual
            )
        }
    }
}