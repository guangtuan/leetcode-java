package tech.igrant.weekly_contest.no310.no2

class Solution {

    fun partitionString(s: String): Int =
            s.fold(Pair(mutableSetOf(), 1)) { acc: Pair<MutableSet<Char>, Int>, i ->
                if (acc.first.add(i)) acc else Pair(mutableSetOf(i), acc.second + 1)
            }.second

}