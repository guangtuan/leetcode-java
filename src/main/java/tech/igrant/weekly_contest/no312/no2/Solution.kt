package tech.igrant.weekly_contest.no312.no2


class Solution {
    fun longestSubarray(nums: IntArray): Int {
        // 找到和 max 相等并且最右边的下标
        fun find(intArray: IntArray, target: Int): Int {
            var ans = -1
            for (i in target + 1 until intArray.size) {
                if (intArray[i] == intArray[target]) {
                    ans = i
                } else {
                    return ans
                }
            }
            return ans
        }

        val max = nums.sortedDescending()[0]
        var ans = 1
        var i = 0
        while (i < nums.size) {
            if (nums[i] != max) {
                i++
            } else {
                val found = find(nums, i)
                if (found == -1) {
                    return ans
                }
                ans = ans.coerceAtLeast(found - i + 1)
                i = found + 1
            }
        }
        return ans
    }

}
