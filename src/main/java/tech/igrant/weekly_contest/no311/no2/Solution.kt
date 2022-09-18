package tech.igrant.weekly_contest.no311.no2

class Solution {

    fun longestContinuousSubstring(s: String): Int {
        if (s.length == 1) {
            return 1
        }
        var ans = 1
        var i = 0
        var j = 1
        while (j <= s.length - 1) {
            if (s[j] - s[j - 1] == 1) {
                ans = ans.coerceAtLeast(j - i + 1)
                j += 1
            } else {
                i++
                j = i + 1
            }
        }
        return ans
    }

}