package tech.igrant.daily.no788

import org.junit.Test

import org.junit.Assert.*
import kotlin.system.measureTimeMillis

class SolutionTest {

    class TestCase(val n: Int, val exp: Int)

    val testCases = listOf(
            TestCase(111111111, 6715760),
            TestCase(5879, 1255),
            TestCase(9875, 2257),
            TestCase(111, 44),
            TestCase(1111, 360),
            TestCase(10, 4)
    )

    val solution = Solution()

    @Test
    fun rotatedDigits() {
        testCases.forEach {
            val cost = measureTimeMillis {
                println("input is ${it.n}")
                val act = solution.rotatedDigits(it.n)
                assertEquals(
                        it.exp,
                        act)
            }
            println("with cache cost $cost")
        }
    }

}