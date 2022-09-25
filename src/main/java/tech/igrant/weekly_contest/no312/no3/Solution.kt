package tech.igrant.weekly_contest.no312.no3

class Solution {

    fun goodIndices(nums: IntArray, k: Int): List<Int> {
        // 正序：算出每一个位置（包含自身）前的非递增子数组长度
        // 倒序：算出每一个位置（包含自身）后的非递减子数组长度
        val noneInc = IntArray(nums.size) { 1 }
        for (i in 1..nums.size - k) {
            if (nums[i] <= nums[i - 1]) {
                noneInc[i] = noneInc[i - 1] + 1
            }
        }
        val noneDec = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo k) {
            if (nums[i] <= nums[i + 1]) {
                noneDec[i] = noneDec[i + 1] + 1
            }
        }
        return IntArray(nums.size - k - k) { it + k }.filter { i -> noneInc[i - 1] >= k && noneDec[i + 1] >= k }
    }

}