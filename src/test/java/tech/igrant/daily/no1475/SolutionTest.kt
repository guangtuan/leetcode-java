package tech.igrant.daily.no1475

import org.junit.Assert
import org.junit.Test
import tech.igrant.support.JSON

class SolutionTest {

    class TestCase(val prices: IntArray, val exp: IntArray)

    val testCases = listOf(
            TestCase(intArrayOf(4, 7, 1, 9, 4, 8, 8, 9, 4), intArrayOf(3, 6, 1, 5, 0, 0, 4, 5, 4)),
            TestCase(intArrayOf(8, 4, 6, 2, 3), intArrayOf(4, 2, 4, 2, 3)),
            TestCase(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 3, 4, 5)),
            TestCase(intArrayOf(10, 1, 1, 6), intArrayOf(9, 0, 1, 6))
    )

    val solution = Solution()

    @Test
    fun finalPrices() {
        for (testCase in testCases) {
            JSON.printJSON(testCase)
            val actual = solution.finalPrices(testCase.prices)
            JSON.printJSON(actual)
            Assert.assertArrayEquals(
                    testCase.exp,
                    actual
            )
        }
    }

}