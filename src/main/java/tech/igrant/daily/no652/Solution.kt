package tech.igrant.daily.no652

import tech.igrant.TreeNode

class Solution {

    // 遍历所有的节点，得到值，去重后给出答案

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val st = mutableMapOf<String, Int>()
        return root?.let {
            val found = mutableListOf<TreeNode>()
            bfs(root, st, found)
            found
        } ?: emptyList()
    }

    private fun bfs(root: TreeNode, cache: MutableMap<String, Int>, found: MutableList<TreeNode>): String {
        val v = "${root.`val`}"
        val l = root.left?.let { bfs(it, cache, found) }
        val r = root.right?.let { bfs(it, cache, found) }
        val ret = listOf(
            v,
            l?.let { "l$it" } ?: "ln",
            r?.let { "r$it" } ?: "rn"
        ).joinToString(":")
        cache[ret]?.let {
            if (it != 2) {
                found.add(root)
                cache[ret] = 2
            }
        } ?: run {
            cache[ret] = 1
        }
        return ret
    }

}