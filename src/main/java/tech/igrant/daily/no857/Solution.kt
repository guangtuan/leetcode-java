package tech.igrant.daily.no857

import java.util.*
import kotlin.math.min

class Solution {

    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {

        fun rById(id: Int): Double = wage[id] * 1.0 / quality[id]

        // r = wage / quality -> 溢价比
        // 溢价比高 的排在前面
        // 如果按照 r(i) 结算工资，r值比较小的人都可以拿到期望值以上的工资
        val ids = IntArray(quality.size) { it }.sortedBy { rById(it) }

        fun rBySortedPosition(i: Int): Double = rById(ids[i])

        val pq = PriorityQueue<Int> { i1, i2 -> i2 - i1 }
        var sumQ = 0.0
        for (pos in 0 until k) {
            pq.offer(quality[ids[pos]])
            sumQ += quality[ids[pos]]
        }
        // 工资总和 = 质量总和 * (工资/质量)
        // 因此，质量总和越小越好
        var ans = sumQ * rBySortedPosition(k - 1)
        for (pos in k until quality.size) {
            val q = quality[ids[pos]]
            if (q < pq.peek()) {
                sumQ -= pq.poll() - q
                pq.offer(q)
                ans = min(ans, sumQ * rBySortedPosition(pos))
            }
        }
        return ans
    }

}