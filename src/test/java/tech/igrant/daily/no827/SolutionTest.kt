package tech.igrant.daily.no827

import org.junit.Test

import org.junit.Assert.*
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(val grid: Array<IntArray>, val exp: Int)

    val testCaseList = listOf(
        TestCase(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(1, 0)
            ),
            exp = 4
        ),
        TestCase(
            arrayOf(
                intArrayOf(1, 0), intArrayOf(0, 1)
            ),
            exp = 3
        ),
        TestCase(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(1, 1)
            ),
            exp = 4
        )
    )

    val solution = Solution()

    @Test
    fun largestIsland() {
        testCaseList.forEach {
            JSON.printJSON(it)
            val act = solution.largestIsland(it.grid)
            assertEquals(
                it.exp,
                act
            )
        }
    }

}