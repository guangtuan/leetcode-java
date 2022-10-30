package tech.igrant.weekly_contest.no317.no3

import kotlin.math.pow

class Solution {

    private fun numberToIntList(n: Long): List<Int> {
        if (n < 10) {
            return listOf(n.toInt())
        }
        val curr = n % 10
        return numberToIntList(n / 10).toMutableList().apply { this.add(curr.toInt()) }.toList()
    }

    fun makeIntegerBeautiful(n: Long, target: Int): Long = numberToIntList(n)
            .let { p ->
                toNumber(doRec(target, p, p.size - 1)) - n
            }

    private fun doRec(target: Int, bits: List<Int>, cursor: Int): List<Int> {
        return when {
            bits.sum() <= target -> bits
            else -> doRec(target, increase(bits, cursor), cursor.dec())
        }
    }

    private fun toNumber(l: List<Int>): Long =
            l.mapIndexed { index, i -> (i * (10.toDouble().pow((l.size - index - 1).toDouble()))).toLong() }.sum()

    private fun increase(p: List<Int>, cursor: Int): List<Int> {
        return when (cursor) {
            0 -> (mutableListOf(1, 0).apply { this.addAll(p.subList(1, p.size)) }).toList()

            else -> p.mapIndexed { index, i ->
                when (index) {
                    cursor -> 0
                    cursor - 1 -> i + 1
                    else -> i
                }
            }
        }
    }

}