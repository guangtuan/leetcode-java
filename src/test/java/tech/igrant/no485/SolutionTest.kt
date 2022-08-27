package tech.igrant.no485

import org.junit.Assert.assertEquals
import org.junit.Test

class SolutionTest {

    data class TestCase(val nums: IntArray, val exp: Int)

    val testCases: List<TestCase> = listOf(
        TestCase(intArrayOf(1, 1, 0, 1, 1, 1), 3),
        TestCase(intArrayOf(1, 0, 1, 1, 0, 1), 2),
        TestCase(intArrayOf(0, 0, 0, 0, 0, 1), 1),
    )

    val solution = Solution()

    @Test
    fun findMaxConsecutiveOnes() {
        testCases.forEach {
            println(it)
            val actual = solution.findMaxConsecutiveOnes(it.nums)
            assertEquals(it.exp, actual)
        }
    }

}