package tech.igrant.plan.array.pascalsTriangle2

class Solution {

    fun getRow(rowIndex: Int): List<Int> = next(rowIndex, listOf(1))

    fun next(rowIndex: Int, pre: List<Int>): List<Int> = when (rowIndex) {
        0 -> pre
        else -> next(
                rowIndex.dec(),
                mutableListOf(1).apply {
                    (0..pre.size - 2).forEach { i -> this.add(pre[i] + pre[i + 1]) }
                    this.add(1)
                }
        )
    }

}
