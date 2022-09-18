package tech.igrant.weekly_contest.no311.no4

class Solution {

    fun sumPrefixScores(words: Array<String>): IntArray {
        // map 除了出现的次数，再存储一个出现的位置
        val prefixToIndex = st(words)
        val ret = IntArray(words.size) { 0 }
        for (value in prefixToIndex.values) {
            for (i in value) {
                ret[i] += value.size
            }
        }
        return ret
    }

    fun st(words: Array<String>): MutableMap<String, MutableList<Int>> {
        val prefixToIndex = mutableMapOf<String, MutableList<Int>>()
        for (i in words.indices) {
            val word = words[i]
            var tmp = ""
            for (j in word.indices) {
                tmp += word[j]
                prefixToIndex.computeIfAbsent(tmp) {_ -> mutableListOf() }.add(i)
            }
        }
        return prefixToIndex
    }

}