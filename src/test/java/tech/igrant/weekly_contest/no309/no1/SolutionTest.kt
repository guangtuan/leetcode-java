package tech.igrant.weekly_contest.no309.no1

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    class TestCase(val s: String, val distance: IntArray, val exp: Boolean)

    val testCases = listOf(
            TestCase("aa", intArrayOf(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), false),
            TestCase("abaccb", intArrayOf(1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), true)
    )

    val solution = Solution()

    @Test
    fun test() {
        for (testCase in testCases) {
            val act = solution.checkDistances(testCase.s, testCase.distance)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}