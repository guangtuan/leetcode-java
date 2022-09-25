package tech.igrant.weekly_contest.no312.no3

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val k: Int, val exp: List<Int>)

    val testCases = listOf(
            TestCase(intArrayOf(878724, 201541, 179099, 98437, 35765, 327555, 475851, 598885, 849470, 943442), 4, listOf(4, 5)),
            TestCase(intArrayOf(2, 1, 1, 2), 2, listOf()),
            TestCase(intArrayOf(2, 1, 1, 1, 3, 4, 1), 3, listOf()),
            TestCase(intArrayOf(2, 1, 1, 1, 3, 4, 1), 2, listOf(2, 3))
    )

    val solution = Solution()

    @Test
    fun goodIndices() {
        testCases.forEach {
            val goodIndices = solution.goodIndices(it.nums, it.k)
            assertArrayEquals(
                    it.exp.toIntArray(),
                    goodIndices.toIntArray(),
            )
        }
    }
}