package tech.igrant.daily.no667

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class SolutionTest {

    private class TestCase(val n: Int, val k: Int, val exp: IntArray)

    private val ts: List<TestCase> = listOf(
        TestCase(n = 8, k = 7, exp = intArrayOf(1, 8, 2, 7, 3, 6, 4, 5)),
        TestCase(n = 3, k = 1, exp = intArrayOf(1, 2, 3)),
        TestCase(n = 3, k = 2, exp = intArrayOf(1, 3, 2))
    )

    private val solution = Solution()

    @Test
    fun constructArray() {
        ts.forEach {
            val act = solution.constructArray(it.n, it.k)
            assertContentEquals(
                it.exp,
                act
            )
        }
    }

}