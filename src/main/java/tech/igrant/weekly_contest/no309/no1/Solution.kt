package tech.igrant.weekly_contest.no309.no1

class Solution {

    fun checkDistances(s: String, distance: IntArray): Boolean {
        val acc = mutableMapOf<Char, Int>()
        for (i in s.indices) {
            val v = s[i]
            acc[v]?.let {
                val ans = i - it - 1
                if (distance[v - 'a'] != ans) {
                    return false
                }
            } ?: run {
                acc[v] = i
            }
        }
        return true
    }

}