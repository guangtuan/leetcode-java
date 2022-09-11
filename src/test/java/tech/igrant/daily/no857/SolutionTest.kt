package tech.igrant.daily.no857

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.pow

class SolutionTest {

    class TestCase(val quality: IntArray, val wage: IntArray, val k: Int, val exp: Double)

    val testCases = listOf(
            TestCase(
                    intArrayOf(10, 20, 5),
                    intArrayOf(70, 50, 30),
                    2,
                    105.00000
            )
    )

    val solution = Solution()

    @Test
    fun mincostToHireWorkers() {
        testCases.forEach {
            val actual = solution.mincostToHireWorkers(it.quality, it.wage, it.k)
            assertEquals(
                    it.exp,
                    actual,
                    10.toDouble().pow(-5)
            )
        }
    }
}