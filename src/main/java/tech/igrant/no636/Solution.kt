package tech.igrant.no636

import java.util.*

class Solution {

    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val ans = IntArray(n)
        val stack = Stack<Int>()
        var curr = -1
        for (i in logs.indices) {
            val (fStr, op, tsStr) = logs[i].split(":")
            val f = fStr.toInt()
            val ts = tsStr.toInt()
            if (op == "start") {
                if (stack.isNotEmpty()) {
                    ans[stack.peek()] += ts - curr
                }
                stack.push(f)
                curr = ts
            } else {
                ans[stack.pop()] += ts - curr + 1
                curr = ts + 1
            }
        }
        return ans
    }

}