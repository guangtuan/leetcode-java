package tech.igrant.no485

class Solution {

    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var ans = 0
        var count = 0
        for (num in nums) {
            // 遇到 0，计数清零
            if (num == 0) {
                count = 0
            } else {
                // 遇到 1，计数增加，并且和答案比较
                count++
                if (count > ans) {
                    ans = count
                }
            }
        }
        return ans
    }

}