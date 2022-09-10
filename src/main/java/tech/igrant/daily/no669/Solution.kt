package tech.igrant.daily.no669

class Solution {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
        return root?.let {
            when {
                it.`val` < low -> {
                    return trimBST(it.right, low, high)
                }
                it.`val` > high -> {
                    return trimBST(it.left, low, high)
                }
                else -> {
                    it.left = trimBST(it.left, low, high)
                    it.right = trimBST(it.right, low, high)
                    root
                }
            }
        }
    }

}