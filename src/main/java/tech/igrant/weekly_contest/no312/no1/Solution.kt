package tech.igrant.weekly_contest.no312.no1

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> =
            heights.toTypedArray().zip(names).sortedByDescending { it.first }.map { it.second }.toTypedArray()

}