package tech.igrant.weekly_contest.no309.no2

import kotlin.math.abs

class Solution {

    private val p = 1000000007L

    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val delta = abs(endPos - startPos)
        val negCount = (k - delta) / 2
        return if (delta > k || delta % 2 != k % 2) 0 else comb(negCount, k)
    }

    private fun comb(small: Int, big: Int): Int {
        // 阶乘从 1 算起
        val factorial = LongArray(big + 1) { 1 }
        for (index in 1 until factorial.size) {
            factorial[index] = index.times(factorial[index - 1]) % p
        }
        return (factorial[big]
                * (reverseForMod(factorial[small])) % p
                * (reverseForMod(factorial[big - small])) % p
                ).toInt()
    }

    /**
     * 对于第二种方法，因为在算法竞赛中模数p总是质数，所以可以利用费马小定理 ：
     *  b ** (p - 1) mod p = 1
     * 可以直接得到  的逆元是 b ** (p - 2) , 使用 快速幂 求解即可。
     */
    private fun reverseForMod(num: Long): Long {
        // num ** (p - 2)
        return quickPowWithMod(num, p - 2, p)
    }

    private fun quickPowWithMod(num: Long, ratio: Long, p: Long): Long {
        return when (ratio) {
            1L -> num % p

            else -> if (ratio % 2 == 0L) {
                val l = quickPowWithMod(num, (ratio / 2), p) % p
                l * l % p
            } else {
                val l = quickPowWithMod(num, (ratio / 2), p) % p
                l * l % p * num % p
            }
        }
    }

}