package tech.igrant.weekly_contest.no320

class Solution {

    private fun ok(i: Int, j: Int, k: Int, nums: IntArray): Boolean {
        val a = nums[i]
        val b = nums[j]
        val c = nums[k]
        return a != b && b != c && a != c
    }

    fun unequalTriplets(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            for (j in i until nums.size) {
                for (k in j until nums.size) {
                    if (ok(i, j, k, nums)) {
                        ans += 1
                    }
                }
            }
        }
        return ans
    }

}