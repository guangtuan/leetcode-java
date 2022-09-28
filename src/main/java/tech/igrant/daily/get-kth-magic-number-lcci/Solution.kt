package tech.igrant.daily.`get-kth-magic-number-lcci`

class Solution {
    fun getKthMagicNumber(k: Int): Int {
        val result = Array(k + 1) { 1 }
        var p3 = 1
        var p5 = 1
        var p7 = 1
        for (i in 2 until result.size) {
            val n3 = result[p3] * 3
            val n5 = result[p5] * 5
            val n7 = result[p7] * 7
            val m = n3.coerceAtMost(n5).coerceAtMost(n7)
            if (m == n3) {
                p3++
            }
            if (m == n5) {
                p5++
            }
            if (m == n7) {
                p7++
            }
            result[i] = m
        }
        return result[k]
    }
}