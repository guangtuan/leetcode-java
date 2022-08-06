package tech.igrant.no3

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    data class TestCase(val s: String, val exp: Int)

    val testCases = listOf(
        TestCase(s = " ", exp = 1),
        TestCase(s = "jbpnbwwd", exp = 4),
        TestCase(s = "abba", exp = 2),
        TestCase(s = "", exp = 0),
        TestCase(s = "abcabcbb", exp = 3),
        TestCase(s = "pwwkew", exp = 3),
        TestCase(s = "bbbbb", exp = 1)
    )

    val solution = Solution()

    @Test
    fun lengthOfLongestSubstring() {
        // 输入 p，结果 p
        // 输入 w，结果 p,w
        // 输入 w，结果 w
        // 输入 k，结果 w,k
        // 输入 e，结果 w,k,e
        // 输入 w，结果 k,e,w
        for (testCase in testCases) {
            println(testCase)
            assertEquals(
                testCase.exp,
                solution.lengthOfLongestSubstring(testCase.s)
            )
        }
    }

}