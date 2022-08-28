package tech.igrant.no210

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SolutionTest {

    data class Tc(val numCourses: Int, val prerequisites: Array<IntArray>, val exp: IntArray)

    private val ts = listOf(
            Tc(
                    numCourses = 3,
                    prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1)),
                    exp = intArrayOf()
            ),
            Tc(
                    numCourses = 2,
                    prerequisites = arrayOf(intArrayOf(1, 0)),
                    exp = intArrayOf(0, 1)
            ),
    )

    private val solution = Solution()

    @Test
    fun findOrder() {
        for (t in ts) {
            val actual = solution.findOrder(t.numCourses, t.prerequisites)
            assertArrayEquals(
                    t.exp,
                    actual
            )
        }
    }

}