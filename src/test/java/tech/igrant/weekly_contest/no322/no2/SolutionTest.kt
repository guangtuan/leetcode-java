package tech.igrant.weekly_contest.no322.no2

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val skill: IntArray,
            val exp: Long,
    )

    val testCases = listOf(
            TestCase(
                    skill = intArrayOf(2, 1, 5, 2),
                    exp = -1
            ),
            TestCase(
                    skill = intArrayOf(1, 1, 2, 3),
                    exp = -1
            ),
            TestCase(
                    skill = intArrayOf(3, 4),
                    exp = 12
            ),
            TestCase(
                    skill = intArrayOf(3, 2, 5, 1, 3, 4),
                    exp = 22
            )
    )

    val solution = Solution()

    @Test
    fun dividePlayers() {
        testCases.forEach {
            val ret = solution.dividePlayers(it.skill)
            Assert.assertEquals(
                    it.exp,
                    ret
            )
        }
    }
}