package tech.igrant.weekly_contest.no318.no3

import java.util.PriorityQueue

class Solution {

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var copyOfK = k
        // 两个堆
        if (costs.size >= candidates * 2) {
            var left = candidates
            var right = costs.size - candidates - 1
            val pq1 = PriorityQueue<Int>().apply {
                this.addAll(costs.slice(IntRange(start = 0, endInclusive = left - 1)))
            }
            val pq2 = PriorityQueue<Int>().apply {
                this.addAll(costs.slice(IntRange(right + 1, costs.size - 1)))
            }
            var res = 0L
            while (left <= right) {
                if (pq1.peek() <= pq2.peek()) {
                    res += pq1.poll()
                    pq1.add(costs[left])
                    left++
                } else {
                    res += pq2.poll()
                    pq2.add(costs[right])
                    right--
                }
                if (--copyOfK == 0) {
                    return res
                }
            }
            pq1.addAll(pq2)
            while (copyOfK -- != 0) {
                res += pq1.poll()
            }
            return res
        } else {
            return costs.sorted().subList(0, k).sum().toLong()
        }
    }

}