package tech.igrant.plan.array.rotateArray

class Solution {

    fun rotate(nums: IntArray, k: Int): Unit {
        val kMod = k % nums.size
        val mid = nums.size - kMod
        val p1 = nums.slice(IntRange(start = 0, endInclusive = mid - 1))
        val p2 = nums.slice(IntRange(start = mid, endInclusive = nums.size - 1))
        val merge = p2.toMutableList().apply {
            this.addAll(p1)
        }
        merge.forEachIndexed { index, i -> nums[index] = i }
    }

}