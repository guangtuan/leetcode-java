package tech.igrant.weekly_contest.no317.no1

import org.junit.Assert
import org.junit.Test

class SolutionTest {
    class TestCase(
            val nums: IntArray,
            val exp: Int
    )

    val testCases = listOf(
            TestCase(intArrayOf(1,3,6,10,12,15), 9),
            TestCase(intArrayOf(1,2,4,7,10), 0)
    )

    val solution = Solution()

    @Test
    fun test() {
        testCases.forEach {
            val averageValue = solution.averageValue(it.nums)
            Assert.assertEquals(
                    it.exp,
                    averageValue
            )
        }
    }

}