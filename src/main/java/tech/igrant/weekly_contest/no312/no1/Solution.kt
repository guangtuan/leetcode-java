package tech.igrant.weekly_contest.no312.no1

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val sortedIndex = heights.mapIndexed { i, h -> Pair(i, h) }.sortedByDescending { it.second }.map { it.first }
        val lookupByIndex = names.mapIndexed { i, n -> Pair(i, n) }.associateBy { it.first }
        return sortedIndex.mapNotNull { lookupByIndex[it] }.map { it.second }.toTypedArray()
    }
}