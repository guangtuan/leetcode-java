package tech.igrant.plan.array.no453

class Solution {

    fun minMoves(nums: IntArray): Int = nums.minOrNull()
            ?.let { min -> nums.fold(0) { acc: Int, value -> acc + value - min } }
            ?: 0

}