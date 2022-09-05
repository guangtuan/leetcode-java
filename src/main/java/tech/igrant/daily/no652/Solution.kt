package tech.igrant.daily.no652

import tech.igrant.TreeNode

class Solution {

    // 遍历所有的节点，得到值，去重后给出答案

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> = root
        ?.let {
            mutableListOf<TreeNode>().apply {
                bfs(root, mutableSetOf(), mutableSetOf(), this)
            }
        }
        ?: emptyList()

    private fun bfs(
        root: TreeNode,
        c1: MutableSet<String>,
        c2: MutableSet<String>,
        found: MutableList<TreeNode>
    ): String {
        val v = "#${root.`val`}"
        val l = root.left?.let { bfs(it, c1, c2, found) }?.let { "l$it" } ?: "ln"
        val r = root.right?.let { bfs(it, c1, c2, found) }?.let { "r$it" } ?: "rn"
        return "$v$l$r".also {
            if (!c1.add(it) && c2.add(it)) {
                found.add(root)
            }
        }
    }

}