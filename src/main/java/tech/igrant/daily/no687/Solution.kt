package tech.igrant.daily.no687

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    var res = 0

    fun longestUnivaluePath(root: TreeNode?): Int {
        cal(root)
        return res
    }

    private fun cal(node: TreeNode?): Int {
        return node?.let {
            val l = cal(it.left)
            val r = cal(it.right)
            val l2 = if (it.left?.`val` == it.`val`) l + 1 else 0
            val r2 = if (it.right?.`val` == it.`val`) r + 1 else 0
            res = max(res, l2 + r2)
            return max(l2, r2)
        } ?: 0
    }

}