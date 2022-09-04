package tech.igrant.weekly_contest.no309.no3

class Solution {

    fun longestNiceSubarray(nums: IntArray): Int {
        var ans = 1
        val lastElegant = IntArray(nums.size) { -1 }
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val elegant = elegant(lastElegant, nums, i, j)
                if (elegant) {
                    ans = ans.coerceAtLeast(j - i + 1)
                    lastElegant[i] = j
                } else {
                    break
                }
            }
        }
        return ans
    }

    private fun elegant(lastElegant: IntArray, nums: IntArray, i: Int, j: Int): Boolean {
        if (lastElegant[i] != -1) {
            for (start in i until j) {
                if (nums[j].and(nums[start]) != 0) {
                    return false
                }
            }
            return true
        }
        for (start in i..j) {
            for (next in start + 1..j) {
                if (nums[start].and(nums[next]) != 0) {
                    return false
                }
            }
        }
        return true
    }

}