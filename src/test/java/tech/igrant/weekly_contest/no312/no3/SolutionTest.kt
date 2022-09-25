package tech.igrant.weekly_contest.no312.no3

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val k: Int, val exp: List<Int>)

    val testCases = listOf(
            TestCase(
                    intArrayOf(
                            813026, 739346, 166403, 3529, 2741, 2709, 1377, 102, 69, 11, 11, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 44107, 671930, 750222, 882786, 980351, 983285, 985794, 986115, 993109, 993649, 997371, 999128, 999834, 999997, 999998, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000, 792798, 800896, 544689, 354954
                    ),
                    23,
                    listOf(23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45)
            ),
            TestCase(intArrayOf(144543, 40277, 15939, 6523, 278810, 706219, 998415), 2, listOf(2, 3, 4)),
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