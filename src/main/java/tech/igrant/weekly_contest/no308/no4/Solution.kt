package tech.igrant.weekly_contest.no308.no4

import java.util.*

class Solution {

    private fun sort(conditions: Array<IntArray>, k: Int): Map<Int, Int> {
        // 1 到 k的前置节点
        val g = Array(k + 1) { mutableListOf<Int>() }
        // 统计一个元素的依赖数量
        val inDeg = IntArray(k + 1)
        for ((x, y) in conditions) {
            // x 被 y 依赖
            g[x].add(y)
            // 统计每一个元素的依赖数量
            inDeg[y]++
        }
        val order = mutableListOf<Int>()
        // 初始化队列
        val q = ArrayDeque(Array(k) { it + 1 }.filter { inDeg[it] == 0 }.toList())
        while (q.isNotEmpty()) {
            q.removeFirst().let { x ->
                order.add(x)
                g[x].forEach {
                    // 当 x 被移除，依赖 x 的元素的依赖数量都应该减去 1
                    if (--inDeg[it] == 0) {
                        // 当这个元素没有依赖，则加入队列
                        q.add(it)
                    }
                }
            }
        }
        if (order.size != k) {
            return emptyMap()
        }
        return order.foldIndexed(mutableMapOf()) { index, acc, value ->
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
            return Array(0) { IntArray(0) }
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