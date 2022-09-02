package tech.igrant.daily.no687

import org.junit.Assert
import org.junit.Test

class SolutionTest {

    class TestCase(val root: TreeNode?, val exp: Int)

    // [1,null,1,1,1,1,1,1]
    // 1
    // null, 1
    // null, null, 1, 1

    val testCases = listOf(
            TestCase(TreeNode(1).also {
                it.left = TreeNode(4).also { c1 ->
                    c1.left = TreeNode(4)
                    c1.right = TreeNode(4)
                }
                it.right = TreeNode(5).also { c2 ->
                    c2.right = TreeNode(5)
                }
            }, 2),
            TestCase(TreeNode(1).also {
                it.right = TreeNode(1).also { c1 ->
                    c1.left = TreeNode(1).also { c2 ->
                        c2.left = TreeNode(1)
                        c2.right = TreeNode(1)
                    }
                    c1.right = TreeNode(1).also { c3 ->
                        c3.left = TreeNode(1)
                    }
                }
            }, 4)
    )

    val solution = Solution()

    @Test
    fun longestUnivaluePath() {
        for (testCase in testCases) {
            val act = solution.longestUnivaluePath(testCase.root)
            Assert.assertEquals(
                    testCase.exp,
                    act
            )
        }
    }
}