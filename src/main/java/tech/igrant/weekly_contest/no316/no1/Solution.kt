package tech.igrant.weekly_contest.no316.no1

class Solution {
    fun haveConflict(event1: Array<String>, event2: Array<String>): Boolean {
        val ret1 = event1.map {
            val ret = it.split(":")
            ret[0].toInt() * 60 + ret[1].toInt()
        }
        val ret2 = event2.map {
            val ret = it.split(":")
            ret[0].toInt() * 60 + ret[1].toInt()
        }
        for (i in ret1) {
            if (inRangeOf(ret2, i)) {
                return true;
            }
        }
        for (i in ret2) {
            if (inRangeOf(ret1, i)) {
                return true;
            }
        }
        return false
    }

    private fun inRangeOf(range: List<Int>, i: Int): Boolean {
        return range[0] <= i && i <= range[1]
    }

}