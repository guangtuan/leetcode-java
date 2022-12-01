package tech.igrant.weekly_contest.no320.no2

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        val asList = mutableListOf<Int>().apply {
            root?.let { collect(it, this) }
        }
        return queries.map {
            listOf(
                    closetMin(asList, it),
                    closetMax(asList, it)
            )
        }
    }

    private fun collect(root: TreeNode, holder: MutableList<Int>) {
        // 中序遍历，放到数组里
        root.left?.let { l ->
            collect(l, holder)
        }
        holder.add(root.`val`)
        root.right?.let { r ->
            collect(r, holder)
        }
    }


    // 最接近q的，小于q的数
    private fun closetMin(asList: List<Int>, q: Int): Int {
        var left = 0
        var right = asList.size - 1
        var ans = -1
        while (left <= right) {
            val mid = (right + left) / 2
            if (asList[mid] <= q) {
                ans = asList[mid]
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return ans
    }

    // 最接近q的，大于q的数
    private fun closetMax(asList: List<Int>, q: Int): Int {
        var left = 0
        var right = asList.size - 1
        var ans = -1
        while (left <= right) {
            val mid = (right + left) / 2
            if (asList[mid] >= q) {
                ans = asList[mid]
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return ans
    }

}