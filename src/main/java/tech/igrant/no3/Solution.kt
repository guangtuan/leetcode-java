package tech.igrant.no3

class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        // 双指针，找 i, j 范围不重复，维护一个 set
        val st = HashSet<Char>()
        var max = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                if (!st.add(s[j])) {
                    max = max.coerceAtLeast(st.size)
                    st.clear()
                }
            }
            max = max.coerceAtLeast(st.size)
            st.clear()
        }
        return max
    }

}