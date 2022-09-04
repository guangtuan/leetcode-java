package tech.igrant.weekly_contest.no309.no2

import java.math.BigInteger
import kotlin.math.abs

class Solution {

    private val MOD = BigInteger.valueOf(1000000007)

    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val delta = abs(endPos - startPos)
        val negCount = (k - delta) / 2
        if (delta > k || delta % 2 != k % 2) {
            return 0
        }
        return c(negCount, k)
    }

    private fun order(a: Int, b: Int): Pair<Int, Int> = if (a > b) Pair(a, b) else Pair(b, a)

    private fun c(a: Int, b: Int): Int {
        if (a == 0 || a == b) {
            return 1
        }
        val (max, min) = order(b - a + 1, a)
        val upArray = Array(b - max + 1) { (it + max).toBigInteger() }
        val downArray = Array(min) { (it + 1).toBigInteger() }
        return (divide(upArray, downArray) % MOD).toInt()
    }

    private fun divide(up: Array<BigInteger>, down: Array<BigInteger>): BigInteger {
        var res = BigInteger.valueOf(1)
        val use = BooleanArray(down.size) { false }
        for (i in up) {
            res *= i
            for (j in down.size - 1 downTo 0) {
                if (use[j]) continue
                if ((res % down[j]) == BigInteger.ZERO) {
                    res = res.div(down[j])
                    use[j] = true
                }
            }
        }
        return res
    }

}