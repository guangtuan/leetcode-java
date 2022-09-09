package tech.igrant.daily.no1598

import java.util.*

class Solution {

    fun minOperations(logs: Array<String>): Int {
        val stack = Stack<String>()
        for (log in logs) {
            when (log) {
                "../" -> {
                    if (stack.isNotEmpty()) {
                        stack.pop()
                    }
                }

                "./" -> {}
                else -> stack.add(log)
            }
        }
        return stack.size
    }

}