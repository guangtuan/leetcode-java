package tech.igrant.daily.no667

import org.junit.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    private class TestCase(val n: Int, val k: Int, val exp: IntArray)

    private val ts: List<TestCase> = listOf(
        TestCase(
            n = 24,
            k = 4,
            intArrayOf(1, 5, 2, 4, 3, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24)
        ),
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