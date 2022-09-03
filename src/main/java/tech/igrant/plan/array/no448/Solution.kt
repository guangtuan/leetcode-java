package tech.igrant.plan.array.no448

class Solution {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val ans = IntArray(nums.size) { it + 1}
        for (num in nums) {
            ans[num - 1] = -1
        }
        return ans.filter { it != -1 }.toList()
    }

}