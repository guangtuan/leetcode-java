package tech.igrant.weekly_contest.no317.no3

import kotlin.math.pow

class Solution {

    fun parseNumber(n: Long): MutableList<Int> {
        var remain = n
        val ret = mutableListOf<Int>()
        while (remain > 0) {
            val curr = remain % 10
            remain /= 10
            ret.add(0, curr.toInt())
        }
        return ret
    }

    private fun sum(l: List<Int>): Int {
        var ret = 0
        l.forEach { ret += it }
        return ret
    }

    fun makeIntegerBeautiful(n: Long, target: Int): Long {
        val parsed = parseNumber(n)
        var s = parsed.sum()
        var cursor = parsed.size - 1
        while (s > target) {
            inc(parsed, cursor)
            s = sum(parsed)
            cursor -= 1
        }
        val ret = toNumber(parsed)
        println("ret is $ret")
        return ret - n
    }

    private fun toNumber(l: List<Int>): Long {
        return l.mapIndexed { index, i -> (i * (10.toDouble().pow((l.size - index - 1).toDouble()))).toLong() }.sum()
    }

    fun inc(p: MutableList<Int>, cursor: Int) {
        p[cursor] = 0
        if (cursor == 0) {
            p.add(0, 1)
        } else {
            p[cursor - 1] += 1
        }
    }

}