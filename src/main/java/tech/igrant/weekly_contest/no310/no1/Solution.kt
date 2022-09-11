package tech.igrant.weekly_contest.no310.no1

class Solution {

    fun mostFrequentEven(nums: IntArray): Int {
        var max = 0
        val acc = nums.fold(mutableMapOf()) { acc: MutableMap<Int, Int>, i ->
            if (i % 2 == 0) {
                acc[i]?.let { acc[i] = it + 1 } ?: run { acc[i] = 1 }
                acc[i]?.let {
                    max = max.coerceAtLeast(it)
                }
            }
            acc
        }
        if (acc.isEmpty()) {
            return -1
        }
        val sorted = acc.entries.filter { it.value == max }
        val vals = sorted.map { it.key }
        return vals.sorted()[0]
    }

}