package tech.igrant.weekly_contest.no310.no1

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(intArrayOf(0, 1, 2, 2, 4, 4, 1), 2),
            TestCase(intArrayOf(29, 47, 21, 41, 13, 37, 25, 7), -1)
    )

    val solution = Solution()

    @Test
    fun mostFrequentEven() {
        testCases.forEach { it ->
            val act = solution.mostFrequentEven(it.nums)
            assertEquals(
                    it.exp,
                    act
            )
        }
    }
}