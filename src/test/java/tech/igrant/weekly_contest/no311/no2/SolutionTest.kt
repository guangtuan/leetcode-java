package tech.igrant.weekly_contest.no311.no2

import junit.framework.TestCase

class SolutionTest : TestCase() {

    class TestCase(val s: String, val exp: Int)

    val ts = listOf(
        TestCase("awy", 1),
        TestCase("abacaba", 2),
        TestCase("abcde", 5),
    )

    val solution = Solution()

    fun testLongestContinuousSubstring() {
        ts.forEach {
            println("case is $it")
            val act = solution.longestContinuousSubstring(it.s)
            assertEquals(
                it.exp,
                act
            )
        }
    }
}