package tech.igrant.weekly_contest.no322.no1

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val sentence: String,
            val exp: Boolean,
    )

    val testCases = listOf(
            TestCase(
                    sentence = "leetcode exercises sound delightful",
                    exp = true
            ),
            TestCase(
                    sentence = "eetcode",
                    exp = true
            ),
            TestCase(
                    sentence = "Leetcode is cool",
                    exp = false
            ),
    )

    val solution = Solution()

    @Test
    fun isCircularSentence() {
        testCases.forEach {
            Assert.assertEquals(
                    it.exp,
                    solution.isCircularSentence(it.sentence),
            )
        }
    }
}