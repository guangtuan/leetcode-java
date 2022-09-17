package tech.igrant.daily.no1624

class Solution {

    fun maxLengthBetweenEqualCharacters(s: String): Int {
        val acc = s.foldIndexed(mutableMapOf<Char, Pair<Int, Int>>()) { index, acc, c ->
            acc.computeIfPresent(c) { _, present -> Pair(present.first, index - present.first - 1) }
            acc.computeIfAbsent(c) { Pair(index, -1) }
            acc
        }
        return acc.values.map { it.second }.max()
    }

}