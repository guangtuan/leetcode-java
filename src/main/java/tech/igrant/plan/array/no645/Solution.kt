package tech.igrant.plan.array.no645

class Solution {

    fun findErrorNums(nums: IntArray): IntArray {
        val set = Array(nums.size) { it + 1 }.toMutableSet()
        val ret = IntArray(2) { it }
        for (num in nums) {
            if (!set.remove(num)) {
                ret[0] = num
            }
        }
        ret[1] = set.toIntArray()[0]
        return ret
    }

    fun findErrorNums2(nums: IntArray): IntArray {
        // 1 2 3 4 | 2 = 12
        // 1 2 3 4 | 5 = 15
        val st = mutableSetOf<Int>()
        var sum = 0
        val result = IntArray(2) { -1 }
        for (num in nums) {
            sum += num
            if (result[0] == -1 && !st.add(num)) {
                result[0] = num
            }
        }
        result[1] = (1 + nums.size) * nums.size / 2 - sum + result[0]
        return result
    }

    fun findErrorNums3(nums: IntArray): IntArray {
        // 1 2 3 4 | 2 = 12
        // 1 2 3 4 | 5 = 15
        val st = nums.fold(mutableMapOf()) { acc: MutableMap<Int, Int>, i ->
            acc[i] = acc[i]?.plus(1) ?: 1
            acc
        }
        return Array(nums.size) { it + 1 }
                .map { index -> st[index]?.let { Pair(index, it) } ?: Pair(index, 0 ) }
                .filter { it.second != 1 }
                .sortedByDescending { it.second }
                .map { it.first }
                .toIntArray()
    }

}