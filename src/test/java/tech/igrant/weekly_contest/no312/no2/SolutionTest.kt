package tech.igrant.weekly_contest.no312.no2

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(intArrayOf(311155,311155,311155,311155,311155,311155,311155,311155,201191,311155), 8),
            TestCase(intArrayOf(1, 2, 3, 3, 2, 2), 2),
            TestCase(intArrayOf(1, 2, 3, 4), 1)
    )

    val solution = Solution()

    @Test
    fun longestSubarray() {
        testCases.forEach {
            val actual = solution.longestSubarray(it.nums)
            assertEquals(
                    it.exp,
                    actual
            )
        }
    }

}