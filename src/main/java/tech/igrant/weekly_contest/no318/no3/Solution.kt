package tech.igrant.weekly_contest.no318.no3

import java.util.PriorityQueue

class Solution {

    data class Member(
            val cost: Int,
            val idx: Int,
    )

    fun add(pq: PriorityQueue<Member>, idx: Int, costs: IntArray, added: MutableSet<Int>) {
        if (added.add(idx)) {
            pq.add(Member(cost = costs[idx], idx = idx))
        }
    }

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val added = mutableSetOf<Int>()
        val pq = PriorityQueue(
                object : Comparator<Member> {
                    override fun compare(o1: Member, o2: Member): Int {
                        if (o1.cost == o2.cost) {
                            return o1.idx.compareTo(o2.idx)
                        }
                        return o1.cost.compareTo(o2.cost)
                    }
                }
        )
        var left = candidates - 1
        var right = costs.size - left - 1
        if (right >= left) {
            for (i in 0..left) {
                add(pq, i, costs, added)
            }
            for (i in (costs.size - 1) downTo right) {
                add(pq, i, costs, added)
            }
        } else {
            for (i in costs.indices) {
                add(pq, i, costs, added)
            }
        }
        var vk = k
        var res = 0L
        while (vk > 0) {
            val pop = pq.poll()
            res += pop.cost
            vk--
            if (pop.idx <= left) {
                if (right > left) {
                    left++
                    add(pq, left, costs, added)
                }
            } else {
                if (pop.idx >= right) {
                    if (right > left) {
                        right--
                        add(pq, right, costs, added)
                    }
                }
            }
        }
        return res
    }

}