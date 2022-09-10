package tech.igrant.plan.array.no274

class Solution {

    // h 指数的范围是
    // 最小值 0（所有论文都被 0 次引用）
    // 最大值 h 论文数
    // 对 h 的可能性进行二分搜索
    fun hIndex(citations: IntArray): Int = bs(0, citations.size, citations)

    private fun bs(l: Int, r: Int, citations: IntArray): Int {
        // 当符合的时候，向右边界[m, r]移动
        // 不符合的时候，向左边界[l, m - 1]移动
        if (l >= r) {
            return r
        }
        val mid = (l + r + 1) / 2
        return if (match(citations, mid)) bs(mid, r, citations) else bs(l, mid - 1, citations)
    }

    // 判断 h 是否符合定义
    // 数组内有 至少 h 个数字大于 h
    private fun match(citations: IntArray, h: Int): Boolean = citations.filter { it >= h }.size >= h

}