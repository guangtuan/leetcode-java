package tech.igrant.weekly_contest.no318.no2

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val nums: IntArray,
            val k: Int,
            val exp: Long,
    )

    val testCases = listOf(
            TestCase(nums = intArrayOf(1, 1, 1, 7, 8, 9), k = 3, exp = 24),
            TestCase(nums = intArrayOf(1, 5, 4, 2, 9, 9, 9), k = 3, exp = 15),
            TestCase(nums = intArrayOf(4, 4, 4), k = 3, exp = 0),
    )

    val solution = Solution()

    @Test
    fun maximumSubarraySum() {
        testCases.forEach {
            val act = solution.maximumSubarraySum(it.nums, it.k)
            Assert.assertEquals(
                    it.exp,
                    act
            )
        }
    }
}