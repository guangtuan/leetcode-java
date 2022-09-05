package tech.igrant.daily.no652

import tech.igrant.TreeNode

class Solution {

    // 遍历所有的节点，得到值，去重后给出答案

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        return root?.let {
            val found = mutableListOf<TreeNode>()
            val ans = mutableListOf<String>()
            bfs(root, ans, found)
            val st = ans.foldIndexed(mutableMapOf()) { index, acc: MutableMap<String, MutableList<Int>>, s ->
                acc[s]?.add(index) ?: run { acc[s] = mutableListOf(index) }
                acc
            }
            println(st.keys)
            st.filterValues { it.size > 1 }.map { it.value[0] }.map { found[it] }
        } ?: emptyList()
    }

    private fun bfs(root: TreeNode, cache: MutableList<String>, found: MutableList<TreeNode>): String {
        val v = "${root.`val`}"
        val l = root.left?.let { bfs(it, cache, found) }
        val r = root.right?.let { bfs(it, cache, found) }
        val lStr = l?.let { "l$it" } ?: "ln"
        val rStr = r?.let { "r$it" } ?: "rn"
        val ret = listOf(v, lStr, rStr).joinToString(":")
        cache.add(ret)
        found.add(root)
        return ret
    }

}