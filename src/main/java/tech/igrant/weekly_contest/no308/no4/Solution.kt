package tech.igrant.weekly_contest.no308.no4

class Solution {

    private fun sort(conditions: Array<IntArray>, k: Int): Map<Int, Int> {
        val st = mutableMapOf<Int, MutableSet<Int>>()
        for (pair in conditions) {
            val (prev, value) = pair
            st.computeIfAbsent(value) { mutableSetOf() }.add(prev)
        }
        var valuesToSort = IntArray(k) { it + 1 }
        val setSorted = mutableSetOf<Int>()
        val listSorted = mutableListOf<Int>()
        while (valuesToSort.isNotEmpty()) {
            val remain = mutableListOf<Int>()
            for (value in valuesToSort) {
                if (st[value]?.all { setSorted.contains(it) } != false) {
                    listSorted.add(value)
                    setSorted.add(value)
                } else {
                    remain.add(value)
                }
            }
            if (remain.size == valuesToSort.size) {
                return emptyMap()
            }
            valuesToSort = remain.toIntArray()
        }
        return listSorted.foldIndexed(mutableMapOf()) { index, acc, value ->
            acc[value] = index
            acc
        }
    }

    // 预先填充 k * k 的矩阵
    // 横向排序 [3,1,2], 压缩成 val: index 的 map
    // 纵向排序 [3,2,1], 压缩成 val: index 的 map
    // 对 1..k 的每一个数获取他的 rowIndex + colIndex，填充到对应的位置
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        val sortedRow = sort(rowConditions, k)
        val sortedCol = sort(colConditions, k)
        if (sortedRow.isEmpty() || sortedCol.isEmpty()) {
            return Array(0) {IntArray(0)}
        }
        val ret = Array(k) { IntArray(k) { 0 } }
        sortedRow.forEach { (value, rowIndex) ->
            sortedCol[value]?.let { colIndex ->
                ret[rowIndex][colIndex] = value
            }
        }
        return ret
    }

}