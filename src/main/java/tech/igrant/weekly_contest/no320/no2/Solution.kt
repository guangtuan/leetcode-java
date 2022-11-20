package tech.igrant.weekly_contest.no320.no2

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        // 寻找二叉搜索树里，最接近 query 的两个值
        val asList = root?.let { toList(it) } ?: emptyList()
        println(asList)
        return queries.map {
            listOf(
                    closetMin(asList, it),
                    closetMax(asList, it),
            )
        }
    }

    private fun toList(root: TreeNode): MutableList<Int> {
        // 中序遍历，放到数组里
        return mutableListOf<Int>().apply {
            root.left?.let { l ->
                this.addAll(toList(l))
            }
            this.add(root.`val`)
            root.right?.let { r ->
                this.addAll(toList(r))
            }
        }
    }

    private fun closetMin(asList: List<Int>, q: Int): Int {
        return -1
    }

    private fun closetMax(asList: List<Int>, q: Int): Int {
        return -1
    }

}