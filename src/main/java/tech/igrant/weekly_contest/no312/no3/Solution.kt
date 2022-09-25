package tech.igrant.weekly_contest.no312.no3

class Solution {

    fun goodIndices(nums: IntArray, k: Int): List<Int> {
        val notIncrease = BooleanArray(nums.size) { false }
        val notDecrease = BooleanArray(nums.size) { true }
        for (i in 0..nums.size - 2) {
            notIncrease[i] = notIncrease(nums[i], nums[i + 1])
        }
        for (i in 1 until nums.size) {
            notDecrease[i] = notDecrease(nums[i - 1], nums[i])
        }
        val rangeStart = k
        val rangeEnd = nums.size - k - 1
        val ans = mutableListOf<Int>()
        for (i in rangeStart..rangeEnd) {
            val preStart = i - k;
            val preEnd = i - 1;
            val postStart = i + 1;
            val postEnd = i + k;
            if (notInc(notIncrease, preStart, preEnd)) {
                if (notDec(notDecrease, postStart, postEnd)) {
                    ans.add(i)
                }
            }
        }
        return ans
    }

    private fun notDec(notDecrease: BooleanArray, postStart: Int, postEnd: Int): Boolean {
        for (i in postStart + 1..postEnd) {
            if (!notDecrease[i]) {
                return false
            }
        }
        return true
    }

    private fun notInc(notIncrease: BooleanArray, preStart: Int, preEnd: Int): Boolean {
        for (i in preStart until preEnd) {
            if (!notIncrease[i]) {
                return false
            }
        }
        return true
    }

    private fun notIncrease(n1: Int, n2: Int): Boolean {
        return n1 >= n2
    }

    private fun notDecrease(n1: Int, n2: Int): Boolean {
        return n1 <= n2
    }

}