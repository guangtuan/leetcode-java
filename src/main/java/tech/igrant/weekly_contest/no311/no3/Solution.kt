package tech.igrant.weekly_contest.no311.no3

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        var q = root?.let { mutableListOf(it) } ?: emptyList()
        var level = 0
        while (q.isNotEmpty()) {
            if (level % 2 == 1) {
                val toSwapPairs = Array(q.size / 2) { Pair(it, q.size - it - 1) }
                toSwapPairs.forEach { (a, b) ->
                    val n1 = q[a]
                    val n2 = q[b]
                    val tmp = n1.`val`
                    n1.`val` = n2.`val`
                    n2.`val` = tmp
                }
            }
            q = q.map { listOf(it.left, it.right) }.flatten().filterNotNull().toMutableList()
            level += 1
        }
        return root
    }
}

//[2,3,5,8,13,21,34]
//[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
//[7,11,13]
//输入 [2,3,5,7,11,13,17,19,23,29,31,37,41,43,47]
//预期 [2,5,3,7,11,13,17,47,43,41,37,31,29,23,19]