package tech.igrant.no636

import org.junit.Assert
import org.junit.Test

class SolutionTest {

    data class TestCase(val n: Int, val logs: List<String>, val exp: IntArray)

    val testCases = listOf(
        TestCase(2, listOf("0:start:0", "0:start:2", "0:end:5", "1:start:6", "1:end:6", "0:end:7"), intArrayOf(7, 1)),
        TestCase(1, listOf("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"), intArrayOf(8)),
        TestCase(2, listOf("0:start:0", "1:start:2", "1:end:5", "0:end:6"), intArrayOf(3, 4))
    )

    val solution = Solution()

    @Test
    fun exclusiveTime() {
        for (testCase in testCases) {
            println(testCase.logs)
            val actual = solution.exclusiveTime(testCase.n, testCase.logs)
            Assert.assertArrayEquals(
                testCase.exp,
                actual
            )
        }
    }

}