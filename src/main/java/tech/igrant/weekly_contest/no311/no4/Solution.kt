package tech.igrant.weekly_contest.no311.no4

class Solution {

    class TireTree() {
        var count: Int = 0
        var next: MutableMap<Char, TireTree> = mutableMapOf()
    }

    private fun buildTree(words: Array<String>): TireTree {
        val root = TireTree()
        for (word in words) {
            var cursor = root
            for (c in word) {
                cursor.next.computeIfAbsent(c) { TireTree() }
                cursor.next[c]?.let {
                    it.count++
                    cursor = it
                }
            }
        }
        return root
    }

    private fun findCount(word: String, tree: TireTree): Int {
        var ans = 0
        var cursor = tree
        for (c in word) {
            ans += cursor.count
            cursor.next[c]?.let { cursor = it }
        }
        return ans + cursor.count
    }

    fun sumPrefixScores(words: Array<String>): IntArray {
        val tree = buildTree(words)
        return words.map { findCount(it, tree) }.toIntArray()
    }

}