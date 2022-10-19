package tech.igrant.plan.array.rotateArray

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(val nums: IntArray, val k: Int, val exp: IntArray)

    val testCaseList = listOf(
        TestCase(
            nums = intArrayOf(1, 2),
            k = 0,
            exp = intArrayOf(1, 2)
        ),
        TestCase(
            nums = intArrayOf(1, 2),
            k = 2,
            exp = intArrayOf(1, 2)
        ),
        TestCase(
            nums = intArrayOf(1, 2, 3, 4, 5, 6, 7),
            k = 3,
            exp = intArrayOf(5, 6, 7, 1, 2, 3, 4)
        ),
        TestCase(
            nums = intArrayOf(-1),
            k = 2,
            exp = intArrayOf(-1)
        )
    )

    val solution = Solution()

    @Test
    fun rotate() {
        testCaseList.forEach {
            solution.rotate(it.nums, it.k)
            assertEquals(
                it.exp.contentToString(),
                it.nums.contentToString()
            )
        }
    }
}