package tech.igrant.weekly_contest.no309.no2

import org.junit.Test
import kotlin.math.abs
import kotlin.test.assertEquals

class SolutionTest {
    class TestCase(val startPos: Int, val endPos: Int, val k: Int, val exp: Int)

    val testCases = listOf(
            TestCase(startPos = 1, endPos = 10, k = 3, exp = 0),
            TestCase(startPos = 564, endPos = 533, k = 87, exp = 877674567),
            TestCase(startPos = 989, endPos = 1000, k = 99, exp = 934081896),
            TestCase(startPos = 264, endPos = 198, k = 68, exp = 68),
            TestCase(startPos = 88, endPos = 81, k = 7, exp = 1),
            TestCase(startPos = 2, endPos = 5, k = 10, exp = 0),
            TestCase(startPos = 1, endPos = 2, k = 3, exp = 3),
    )

    val solution = Solution()

    @Test
    fun test() {
        for (testCase in testCases) {
            println("diff is ${abs(testCase.startPos - testCase.endPos)}")
            println("k is ${testCase.k}")
            val act = solution.numberOfWays(startPos = testCase.startPos, endPos = testCase.endPos, k = testCase.k)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}