package tech.igrant.no623

import tech.igrant.TreeNode
import java.util.*

class SolutionWithKt {
    fun addOneRow(root: TreeNode, `val`: Int, depth: Int): TreeNode? {
        var d = depth
        when (depth) {
            1 -> {
                return TreeNode(`val`, root, null)
            }
            else -> {
                val q = LinkedList<TreeNode>().also { it.add(root) }
                while (d > 2) {
                    for (i in 0 until q.size) {
                        q.pollFirst()?.run {
                            this.left?.let { q.addLast(it) }
                            this.right?.let { q.addLast(it) }
                        }
                    }
                    d--
                }
                for (treeNode in q) {
                    treeNode.left = TreeNode(`val`, treeNode.left, null)
                    treeNode.right = TreeNode(`val`, null, treeNode.right)
                }
                return root
            }
        }
    }
}