package tech.igrant.weekly_contest.no322.no2

class Solution {

    fun dividePlayers(skill: IntArray): Long {
        val teamCount = skill.size / 2
        val sum = skill.sum()
        if (sum % teamCount != 0) {
            return -1
        }
        val ava = sum / teamCount
        val sorted = skill.sorted()
        var res = 0L
        for (i in 0 until sorted.size / 2) {
            if (sorted[i] + sorted[sorted.size - i - 1] != ava) {
                return -1
            }
            res += sorted[i] * sorted[sorted.size - i - 1]
        }
        return res;
    }

}