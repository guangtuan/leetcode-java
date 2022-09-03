package tech.igrant.daily.no646

import kotlin.math.max

class Solution {

    fun findLongestChain(pairs: Array<IntArray>): Int {
        val dp = Array(pairs.size) { 1 }
        // 按照第一个元素排序好之后，ans[i] 也排好序了
        pairs.sortBy { it[0] }
        for (i in pairs.indices) {
            for (j in 0 until i) {
                val l = pairs[i][0]
                val r = pairs[j][1]
                if (l > r) {
                    dp[i] = max(dp[i], dp[j] + 1)
                }
            }
        }
        return dp[dp.size - 1]
    }

}