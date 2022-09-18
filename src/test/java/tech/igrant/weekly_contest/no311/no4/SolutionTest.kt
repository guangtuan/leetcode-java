package tech.igrant.weekly_contest.no311.no4

import junit.framework.TestCase
import org.junit.Assert
import tech.igrant.support.JSON

class SolutionTest : TestCase() {

    class Input(val words: Array<String>, val exp: IntArray)

    private val inputs = listOf(
        Input(
            arrayOf("abc", "ab", "bc", "b"),
            intArrayOf(5, 4, 3, 2)
        ),
        Input(
            arrayOf("abcd"),
            intArrayOf(4)
        )
    )

    val s = Solution()

    fun testSumPrefixScores() {
        inputs.forEach {
            JSON.printJSONALine(it)
            val act = s.sumPrefixScores(it.words)
            Assert.assertArrayEquals(
                it.exp,
                act
            )
        }
    }
}