package tech.igrant.weekly_contest.no312.no2


class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val max = nums.sortedDescending()[0]
        var ans = 0
        var cnt = 0
        for (num in nums) {
            when (num) {
                max -> ans = ans.coerceAtLeast(++cnt)
                else -> cnt = 0
            }
        }
        return ans
    }

}
