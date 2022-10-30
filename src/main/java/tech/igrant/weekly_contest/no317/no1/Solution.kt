package tech.igrant.weekly_contest.no317.no1

class Solution {

    fun averageValue(nums: IntArray): Int {
        return nums.filter { it % 6 == 0 }.average().toInt()
    }

}