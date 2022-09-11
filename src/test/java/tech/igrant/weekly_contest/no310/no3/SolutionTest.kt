package tech.igrant.weekly_contest.no310.no3

import org.junit.Test

import org.junit.Assert.*
import tech.igrant.support.KtJSON

class SolutionTest {

    class TestCase(val intervals: Array<IntArray>, val exp: Int)

    val testCases = listOfNotNull(
            TestCase(arrayOf(
                    intArrayOf(441459, 446342),
                    intArrayOf(801308, 840640),
                    intArrayOf(871890, 963447),
                    intArrayOf(228525, 336985),
                    intArrayOf(807945, 946787),
                    intArrayOf(479815, 507766),
                    intArrayOf(693292, 944029),
                    intArrayOf(751962, 821744),
            ), 4),
            TestCase(arrayOf(
                    intArrayOf(5, 10),
                    intArrayOf(6, 8),
                    intArrayOf(1, 5),
                    intArrayOf(2, 3),
                    intArrayOf(1, 10),
            ), 3),
            TestCase(arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(5, 6),
                    intArrayOf(8, 10),
                    intArrayOf(11, 13)
            ), 1),
            ClassLoader.getSystemClassLoader().getResource("weekly_contest/no310/no3/case1.json")?.let {
                KtJSON.read(
                        it,
                        TestCase::class.java
                )
            },
            ClassLoader.getSystemClassLoader().getResource("weekly_contest/no310/no3/case2.json")?.let {
                KtJSON.read(
                        it,
                        TestCase::class.java
                )
            },
    )

    val solution = Solution()

    @Test
    fun minGroups() {
        testCases.forEach {
            val act = solution.minGroups(it.intervals)
            assertEquals(
                    it.exp,
                    act
            )
        }
    }
}