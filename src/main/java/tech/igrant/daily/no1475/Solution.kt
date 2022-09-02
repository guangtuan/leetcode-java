package tech.igrant.daily.no1475

import java.util.Stack

class Solution {

    fun finalPrices(prices: IntArray): IntArray {
        val ret = IntArray(prices.size) { 0 }
        val stack = Stack<Int>()
        for (i in prices.size - 1 downTo 0) {
            while (stack.isNotEmpty() && prices[i] < stack.peek()) {
                stack.pop()
            }
            if (stack.isNotEmpty()) {
                ret[i] = prices[i] - stack.peek()
            } else {
                ret[i] = prices[i]
            }
            stack.push(prices[i])
        }
        return ret
    }

}