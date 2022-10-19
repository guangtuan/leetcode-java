package tech.igrant.plan.array.rotateArray

class Solution {

    fun rotate(nums: IntArray, k: Int): Unit {
        val kMod = k % nums.size
        if (kMod == 0 || nums.size == 1) {
            return
        }
        val holder = nums.toList()
        var startIndex = nums.size - kMod
        for (i in nums.indices) {
            if (startIndex > nums.size - 1) {
                startIndex = 0
            }
            nums[i] = holder[startIndex]
            startIndex++
        }
    }

}