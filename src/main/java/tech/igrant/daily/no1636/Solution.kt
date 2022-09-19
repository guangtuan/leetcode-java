package tech.igrant.daily.no1636

class Solution {

    fun frequencySort(nums: IntArray): IntArray {
        val st = nums.fold(mutableMapOf<Int, Int>()) { acc, i ->
            acc[i] = acc[i]?.inc() ?: 1
            acc
        }
        return nums
                .sortedBy { o1 -> ((st[o1] ?: 1) * 100 - o1) }
                .toIntArray()
    }

}