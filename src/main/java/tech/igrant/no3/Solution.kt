package tech.igrant.no3


class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        // 左指针应该设置为 -1，这样子当 index = 0 的时候，区间范围的大小其实是 0 - (-1) = 1
        var left = 0
        var max = 0
        for (right in s.indices) {
            val curr = s[right]
            // 使用 map 检测右侧值是否出现过
            map[curr]?.let { indexWhereRepeat ->
                // 如果出现过，将左指针向右移动，到上一次出现右值的位置（如果这个位置比左指针小，则不移动）
                left = left.coerceAtLeast(indexWhereRepeat + 1)
            }
            // 将右指针和右侧值放入 map
            map[curr] = right
            // 同时计算最长的区间范围
            max = max.coerceAtLeast(right - left + 1)
        }
        return max
    }

}