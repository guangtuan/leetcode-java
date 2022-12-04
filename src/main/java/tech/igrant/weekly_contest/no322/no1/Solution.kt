package tech.igrant.weekly_contest.no322.no1

class Solution {

    fun isCircularSentence(sentence: String): Boolean {
        val each = sentence.split(" ")
        var ans = true
        for (i in each.indices) {
            if (i == each.size - 1) {
                if (each[i].last() != each[0].first()) {
                    ans = false
                }
            } else {
                if (each[i].last() != each[i + 1].first()) {
                    ans = false;
                }
            }
        }
        return ans
    }

}