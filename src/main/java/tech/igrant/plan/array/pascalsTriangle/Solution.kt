package tech.igrant.plan.array.pascalsTriangle

class Solution {

    fun generate(numRows: Int): List<List<Int>> = mutableListOf<List<Int>>().apply {
        this.add(listOf(1))
        for (i in 1 until numRows) {
            this.add(next(this[i - 1]))
        }
    }

    fun next(pre: List<Int>): List<Int> = mutableListOf(1).apply {
        for (i in 0..pre.size - 2) {
            this.add(pre[i] + pre[i + 1])
        }
        this.add(1)
    }

}
