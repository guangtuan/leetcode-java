package tech.igrant.weekly_contest.no318.no3

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val costs: IntArray,
            val k: Int,
            val candidates: Int,
            val exp: Long,
    )

    val testCases = listOf(
            TestCase(
                    costs = intArrayOf(28, 35, 21, 13, 21, 72, 35, 52, 74, 92, 25, 65, 77, 1, 73, 32, 43, 68, 8, 100, 84, 80, 14, 88, 42, 53, 98, 69, 64, 40, 60, 23, 99, 83, 5, 21, 76, 34),
                    k = 32,
                    candidates = 12,
                    exp = 1407
            ),
            TestCase(
                    costs = intArrayOf(31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58),
                    k = 11,
                    candidates = 2,
                    exp = 423
            ),
            TestCase(
                    costs = intArrayOf(1, 2, 4, 1),
                    k = 3,
                    candidates = 3,
                    exp = 4
            ),
            TestCase(
                    costs = intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8),
                    k = 3,
                    candidates = 4,
                    exp = 11
            )
    )

    val solution = Solution()

    @Test
    fun totalCost() {
        testCases.forEach {
            val act = solution.totalCost(
                    costs = it.costs,
                    k = it.k,
                    candidates = it.candidates,
            )
            assertEquals(
                    it.exp,
                    act
            )
        }
    }
}