package tech.igrant.weekly_contest.no316.no2

import tech.igrant.support.JSON

class Solution {
    fun subarrayGCD(nums: IntArray, k: Int): Int {
        if (nums.size == 1) {
            return if (nums[0] == k) 1 else 0
        }
        val indexList = mutableListOf<Int>()
        nums.forEachIndexed { index, i ->
            if (i % k == 0) {
                indexList.add(index)
            }
        }
        if (indexList.isEmpty()) {
            return 0
        }
        // 1,2,3,4
        val ranges = mutableListOf<IntRange>()
        ranges.add(IntRange(start = indexList[0], endInclusive = indexList[0]))
        for (i in 1 until indexList.size) {
            val ele = indexList[i]
            if (canMerge(last(ranges), ele)) {
                setLast(ranges, merge(last(ranges), ele))
            } else {
                ranges.add(IntRange(start = ele, endInclusive = ele))
            }
        }
        // 对每一个区间，做子数组判断
        // 如果子数组包含 k，则返回 true
        // 如果不包含，且长度大于 1，则返回 true
        var ans = 0
        val cache = mutableMapOf<String, Int>()
        for (range in ranges) {
            val part = nums.slice(range)
            // 对 part 求子数组
            ans += getAns(cache, part, k)
        }
        return ans
    }

    private fun merge(r: IntRange, newEnd: Int): IntRange {
        return IntRange(
                start = r.first,
                endInclusive = newEnd
        )
    }

    private fun setLast(ranges: MutableList<IntRange>, merge: IntRange) {
        ranges[ranges.size - 1] = merge
    }

    private fun canMerge(last: IntRange, i: Int): Boolean {
        if (last.last + 1 == i) {
            return true
        }
        return false
    }

    private fun last(ranges: MutableList<IntRange>): IntRange {
        return ranges[ranges.size - 1]
    }

    private fun getAns(cache: MutableMap<String, Int>, part: List<Int>, k: Int): Int {
        var ans = 0
        val subList = subList(part)
        for (ints in subList) {
            if (gcd(cache, ints.sorted(), k) == k) {
                ans += 1
            }
        }
        return ans
    }

    private fun gcd(cache: MutableMap<String, Int>,origin: List<Int>, k: Int): Int {
        val key = origin.joinToString(",")
        val inCache = cache[key]
        if (inCache != null) {
            return inCache
        }
        // 求 origin 数组的最大公因子
        val sorted = origin.sorted()
        var ans = k
        for (i in sorted) {
            if (origin.all { ele -> ele % i == 0 }) {
                ans = i
            } else {
                break
            }
        }
        cache[key] = ans
        return ans
    }

    private fun subList(origin: List<Int>): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        for (i in origin.indices) {
            for (j in i until origin.size) {
                ret.add(origin.subList(i, j + 1))
            }
        }
        return ret
    }

}