package tech.igrant.daily.no1592

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    private class TestCase(val text: String, val exp: String)

    private val ts: List<TestCase> = listOf(
        TestCase(" a ", "a  "),
        TestCase("a", "a"),
        TestCase("  this   is  a sentence ", "this   is   a   sentence")
    )

    private val solution = Solution()

    @Test
    fun reorderSpaces() {
        ts.forEach {
            val act = solution.reorderSpaces(it.text)
            assertEquals(
                it.exp,
                act
            )
        }
    }
}