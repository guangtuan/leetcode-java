package tech.igrant.weekly_contest.no309.no3

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    class TestCase(val nums: IntArray, val exp: Int)

    val testCases = listOf(
            TestCase(intArrayOf(84139415, 693324769, 614626365, 497710833, 615598711, 264, 65552, 50331652, 1, 1048576, 16384, 544, 270532608, 151813349, 221976871, 678178917, 845710321, 751376227, 331656525, 739558112, 267703680), 8),
            TestCase(intArrayOf(744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664), 3),
            TestCase(intArrayOf(135745088, 609245787, 16, 2048, 2097152), 3),
            TestCase(intArrayOf(1), 1),
            TestCase(intArrayOf(3, 1, 5, 11, 13), 1),
            TestCase(intArrayOf(1, 3, 8, 48, 10), 3)
    )

    val solution = Solution()

    @Test
    fun test() {
        for (testCase in testCases) {
            testCase.nums.forEachIndexed { index, i ->
                println("[$index] -> $i")
            }
            val act = solution.longestNiceSubarray(testCase.nums)
            assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}