package tech.igrant.weekly_contest.no320.no2

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        // 寻找二叉搜索树里，最接近 query 的两个值
        return root
                ?.let { it ->
                    queries.map { q ->
                        listOf(
                                minCloset(it, q, -1),
                                maxCloset(it, q, -1),
                        )
                    }
                }
                ?: emptyList()
    }

    private fun minCloset(root: TreeNode, query: Int, pre: Int): Int {
        return when {
            query > root.`val` -> {
                root.right?.let { r -> minCloset(r, query, root.`val`) } ?: root.`val`
            }

            query < root.`val` -> {
                root.left?.let { l -> minCloset(l, query, pre) } ?: pre
            }

            else -> root.`val`
        }
    }

    private fun maxCloset(root: TreeNode, query: Int, pre: Int): Int {
        return when {
            query < root.`val` -> {
                root.left?.let { l -> maxCloset(l, query, root.`val`) } ?: root.`val`
            }

            query > root.`val` -> {
                root.right?.let { r -> maxCloset(r, query, pre) } ?: pre
            }

            else -> root.`val`
        }
    }

}