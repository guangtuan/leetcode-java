package tech.igrant.weekly_contest.no322.no3

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val n: Int,
            val roads: Array<IntArray>,
            val exp: Int,
    )

    val testCases = listOf(
            TestCase(
                    n = 20,
                    roads = arrayOf(
                            intArrayOf(18, 20, 9207),
                            intArrayOf(14, 12, 1024),
                            intArrayOf(11, 9, 3056),
                            intArrayOf(8, 19, 416),
                            intArrayOf(3, 18, 5898),
                            intArrayOf(17, 3, 6779),
                            intArrayOf(13, 15, 3539),
                            intArrayOf(15, 11, 1451),
                            intArrayOf(19, 2, 3805),
                            intArrayOf(9, 8, 2238),
                            intArrayOf(1, 16, 618),
                            intArrayOf(16, 14, 55),
                            intArrayOf(17, 7, 6903),
                            intArrayOf(12, 13, 1559),
                            intArrayOf(2, 17, 3693)
                    ),
                    exp = 55
            ),
            TestCase(
                    n = 4,
                    roads = arrayOf(
                            intArrayOf(1, 2, 2),
                            intArrayOf(1, 3, 4),
                            intArrayOf(3, 4, 7),
                    ),
                    exp = 2
            ),
            TestCase(
                    n = 4,
                    roads = arrayOf(
                            intArrayOf(1, 2, 9),
                            intArrayOf(2, 3, 6),
                            intArrayOf(2, 4, 5),
                            intArrayOf(1, 4, 7),
                    ),
                    exp = 5
            )
    )

    val solution = Solution()

    @Test
    fun minScore() {
        testCases.forEach {
            val act = solution.minScore(it.n, it.roads)
            Assert.assertEquals(
                    it.exp,
                    act
            )
        }
    }
}