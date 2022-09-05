package tech.igrant.daily.no652

import org.junit.Test
import tech.igrant.TreeNode
import tech.igrant.support.JSON
import kotlin.test.assertEquals

class SolutionTest {

    private class TestCase(val root: TreeNode?, val exp: List<TreeNode?>)

    private val ts: List<TestCase> = listOf(
        TestCase(
            root = TreeNode(
                1,
                TreeNode(
                    2,
                    TreeNode(4)
                ),
                TreeNode(
                    3,
                    TreeNode(
                        2,
                        TreeNode(4),
                    ),
                    TreeNode(4)
                )
            ),
            exp = listOf(TreeNode(2, TreeNode(4)), TreeNode(4))
        ),
        TestCase(
            root = TreeNode(
                0,
                TreeNode(
                    0,
                    TreeNode(0)
                ),
                TreeNode(
                    0,
                    null,
                    TreeNode(
                        0,
                        null,
                        TreeNode(0)
                    )
                )
            ),
            exp = listOf(TreeNode(0))
        )
    )

    private val solution = Solution()

    @Test
    fun findDuplicateSubtrees() {
        ts.forEach {
            JSON.printJSON(it)
            val act = solution.findDuplicateSubtrees(it.root)
            assertEquals(
                it.exp.map { each -> JSON.toJSON(each) }.sorted().joinToString("\n"),
                act.map { each -> JSON.toJSON(each) }.sorted().joinToString("\n")
            )
        }
    }

}