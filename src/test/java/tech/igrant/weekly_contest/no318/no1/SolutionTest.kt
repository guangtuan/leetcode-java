package tech.igrant.weekly_contest.no318.no1

import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test

class SolutionTest {
    class TestCase(
            val nums: IntArray,
            val exp: IntArray,
    )

    val testCases = listOf(
            TestCase(
                    intArrayOf(1, 2, 2, 1, 1, 0),
                    intArrayOf(1, 4, 2, 0, 0, 0)
            ),
            TestCase(
                    intArrayOf(0, 1),
                    intArrayOf(1, 0)
            )
    )

    val solution = Solution()

    @Test
    fun test() {
        for (testCase in testCases) {
            val act = solution.applyOperations(testCase.nums)
            assertArrayEquals(
                    testCase.exp,
                    act,
            )
        }
    }
}