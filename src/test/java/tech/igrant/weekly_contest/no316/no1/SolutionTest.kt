package tech.igrant.weekly_contest.no316.no1

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val event1: Array<String>, val event2: Array<String>, val exp: Boolean)

    val testCases = listOf(
            TestCase(arrayOf("01:15", "02:00"), arrayOf("02:00", "03:00"), true),
            TestCase(arrayOf("10:00", "11:00"), arrayOf("14:00", "15:00"), false),
            TestCase(arrayOf("14:13", "22:08"), arrayOf("02:40", "08:08"), false),
            TestCase(arrayOf("01:00", "02:00"), arrayOf("01:20", "03:00"), true)
    )

    val solution = Solution()

    @Test
    fun haveConflict() {
        testCases.forEach {
            assertEquals(
                    solution.haveConflict(it.event1, it.event2),
                    it.exp
            )
        }
    }
}