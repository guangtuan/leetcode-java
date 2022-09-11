package tech.igrant.weekly_contest.no310.no2

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val s: String, val exp: Int)

    val testCases = listOf(
            TestCase("hdklqkcssgxlvehva", 4),
            TestCase("abacaba", 4),
            TestCase("ssssss", 6)
    )

    val solution = Solution()

    @Test
    fun partitionString() {
        testCases.forEach { it ->
            val ret = solution.partitionString(it.s)
            assertEquals(
                    it.exp,
                    ret
            )
        }
    }
}