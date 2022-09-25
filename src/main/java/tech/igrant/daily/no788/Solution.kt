package tech.igrant.daily.no788

class Solution {

    private val fail = 0
    private val keep = 1
    private val ok = 2

    private fun keep(n: Int): Boolean = n == 0 || n == 1 || n == 8

    private fun fail(n: Int): Boolean = n == 3 || n == 4 || n == 7

    private fun stateOfOne(n: Int): Int = when {
        fail(n) -> fail
        keep(n) -> keep
        else -> ok
    }

    private fun state(number: Int, preState: Int, result: IntArray): Int {
        if (result[number] == ok) {
            return ok
        }
        if (result[number] == fail) {
            return fail
        }
        if (result[number] == keep) {
            return merge(keep, preState)
        }
        if (number < 10) {
            val stateOfOne = stateOfOne(number)
            if (stateOfOne == fail) {
                return fail
            }
            return merge(preState, stateOfOne)
        }
        val modState = stateOfOne(number % 10)
        if (modState == fail) {
            return fail
        }
        return state(
                number = number / 10,
                preState = merge(preState, modState),
                result = result
        )
    }

    private fun merge(a: Int, b: Int): Int = when {
        a == ok -> ok
        b == ok -> ok
        else -> keep
    }

    fun rotatedDigits(n: Int): Int {
        val result = IntArray(n + 1) { -1 }
        for (i in 0..n) {
            result[i] = state(i, keep, result)
        }
        return result.filter { it == ok }.size
    }

}