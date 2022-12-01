package tech.igrant.weekly_contest.no320.no2

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    class TestCase(
            val root: Solution.TreeNode?,
            val queries: List<Int>,
            val exp: List<List<Int>>,
    )

    val testCases = listOf(
            TestCase(
                    root = Solution.TreeNode(4).apply {
                        this.right = Solution.TreeNode(9)
                    },
                    queries = listOf(3),
                    exp = listOf(
                            listOf(-1, 4),
                    )
            ),
            TestCase(
                    root = Solution.TreeNode(6).apply {
                        this.left = Solution.TreeNode(2).apply {
                            this.left = Solution.TreeNode(1)
                            this.right = Solution.TreeNode(4)
                        }
                        this.right = Solution.TreeNode(13).apply {
                            this.left = Solution.TreeNode(9)
                            this.right = Solution.TreeNode(15).apply {
                                this.left = Solution.TreeNode(14)
                            }
                        }
                    },
                    queries = listOf(2, 5, 16),
                    exp = listOf(
                            listOf(2, 2),
                            listOf(4, 6),
                            listOf(15, -1)
                    )
            ),
    )

    val solution = Solution()

    @Test
    fun closestNodes() {
        for (testCase in testCases) {
            val act = solution.closestNodes(testCase.root, testCase.queries)
            for ((a, e) in act.zip(testCase.exp)) {
                assertEquals(
                        e.joinToString(","),
                        a.joinToString(",")
                )
            }
        }
    }

}