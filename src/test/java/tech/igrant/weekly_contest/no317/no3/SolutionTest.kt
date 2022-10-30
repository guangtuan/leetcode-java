package tech.igrant.weekly_contest.no317.no3

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val n: Long,
            val target: Int,
            val exp: Long
    )

    val testCases = listOf(
            TestCase(
                    n = 6068060761,
                    target = 3,
                    exp = 3931939239
            ),
            TestCase(
                    n = 999,
                    target = 1,
                    exp  = 1
            ),
            TestCase(
                    n = 1,
                    target = 1,
                    exp  = 0
            ),
            TestCase(
                    n = 467,
                    target = 6,
                    exp = 33
            ),
            TestCase(
                    n = 16,
                    target = 6,
                    exp = 4
            )
    )

    val solution = Solution()

    @Test
    fun makeIntegerBeautiful() {
        for (testCase in testCases) {
            val act = solution.makeIntegerBeautiful(n = testCase.n, target = testCase.target)
            Assert.assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}