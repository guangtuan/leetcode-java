package tech.igrant.plan.array.no697

class Solution {

    class St(val start: Int) {
        var count: Int = -1
        var de: Int = 1
    }

    fun findShortestSubArray(nums: IntArray): Int {
        val st = nums.foldIndexed(mutableMapOf()) { index, acc: MutableMap<Int, St>, value ->
            acc[value]?.let {
                // 存在的时候，计算元素个数和度
                it.count--
                it.de = index - it.start + 1
            } ?: run {
                // 不存在的时候，赋值一个 start
                acc[value] = St(index)
            }
            acc
        }
        return st.values.minWith(compareBy(St::count, St::de))?.de ?: 1
    }

}