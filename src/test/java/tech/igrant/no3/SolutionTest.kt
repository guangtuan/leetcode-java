package tech.igrant.no3

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    data class TestCase(val s: String, val exp: Int)

    val testCases = listOf(
        TestCase(s = "jbpnbwwd", exp = 4),
        TestCase(s = " ", exp = 1),
        TestCase(s = "abcabcbb", exp = 3),
        TestCase(s = "pwwkew", exp = 3),
        TestCase(s = "bbbbb", exp = 1)
    )

    val solution = Solution()

    @Test
    fun lengthOfLongestSubstring() {
        for (testCase in testCases) {
            assertEquals(
                testCase.exp,
                solution.lengthOfLongestSubstring(testCase.s)
            )
        }
    }

}