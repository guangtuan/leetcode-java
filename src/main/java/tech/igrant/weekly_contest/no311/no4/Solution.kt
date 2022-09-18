package tech.igrant.weekly_contest.no311.no4

class Solution {

    companion object {
        fun nth(index: Int): (String) -> Char? {
            return { arr: String ->
                when {
                    arr.length > index -> {
                        arr[index]
                    }

                    else -> null
                }
            }
        }
    }

    class TireTree {
        var count: Int = 0
        val next: MutableMap<Char, TireTree> = mutableMapOf()

        fun insert(str: String, fromIndex: Int = 0) {
            nth(fromIndex)(str)?.let { c ->
                next.computeIfAbsent(c) { TireTree() }.count++;
                next[c]?.insert(str, fromIndex + 1)
            }
        }
    }

    private fun buildTree(words: Array<String>): TireTree = TireTree().apply { words.forEach { this.insert(it) } }

    private fun getCount(tree: TireTree, word: String, index: Int): Int =
        tree.count + (tree.next[nth(index)(word)]?.let { getCount(it, word, index + 1) } ?: 0)


    fun sumPrefixScores(words: Array<String>): IntArray =
        with(buildTree(words)) { words.map { getCount(this, it, 0) }.toIntArray() }

}