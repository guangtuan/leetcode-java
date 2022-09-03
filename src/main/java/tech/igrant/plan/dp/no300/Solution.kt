package tech.igrant.plan.dp.no300

class Solution {

    fun lengthOfLIS(nums: IntArray): Int {
        // 从最后开始算起
        val dp = IntArray(nums.size) { 1 }
        var ans = 1
        // f(i) 表示从 0 到 i 的 lengthOfLIS, nums[i] 必须被选取，因为它参与整个比较的过程
        for (i in 1 until nums.size) {
            // 每个元素和他前边的元素进行比较
            // 如果大于这个元素，则表示两个数是严格递增，f(i) = max(f(j) + 1, f(i))
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                }
            }
            ans = ans.coerceAtLeast(dp[i])
        }
        return ans
    }

}