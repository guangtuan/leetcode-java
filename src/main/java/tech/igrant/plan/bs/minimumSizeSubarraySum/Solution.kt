package tech.igrant.plan.bs.minimumSizeSubarraySum

class Solution {

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        var ans = n + 1
        var s = 0
        var left = 0
        // 初始 left 和 right 相等，遍历的是 right 0..nums.size - 1
        // 将 nums[right] 加入 s
        // 判断 s 去掉 left 元素是不是大于 target，if true，left ->
        // 如果 s 比 target 大，更新元素
        for (right in nums.indices) {
            s += nums[right]
            while (s - nums[left] >= target) {
                s -= nums[left]
                left++
            }
            if (s >= target) {
                ans = ans.coerceAtMost(right - left + 1)
            }
        }
        return if (ans > n) {
            0
        } else ans
    }
}
