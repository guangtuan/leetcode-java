package tech.igrant.weekly_contest.no318.no1

class Solution {

    fun applyOperations(nums: IntArray): IntArray {
        for (i in nums.indices) {
            if (i == nums.size - 1) {
                continue
            }
            if (nums[i] == 0) {
                continue
            }
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2
                nums[i + 1] = 0
            }
        }
        val ret = mutableListOf<Int>()
        var zCount = 0
        for (ele in nums) {
            if (ele != 0) {
                ret.add(ele)
            } else {
                zCount++
            }
        }
        for (i in 0 until zCount) {
            ret.add(0)
        }
        return ret.toIntArray()
    }

}