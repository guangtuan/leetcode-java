package tech.igrant.no761

import java.util.*

class Solution {

    fun makeLargestSpecial(s: String): String {
        if (s.length <= 2) {
            return s
        }
        val subStrs = mutableListOf<String>()
        val stack = Stack<Char>()
        for (i in s.indices) {
            if (s[i] == '1') {
                stack.add(s[i])
            } else {
                stack.pop()
                if (stack.isEmpty()) {
                    val start = subStrs.fold(0) { acc, subStr -> acc + subStr.length }
                    subStrs.add("1${makeLargestSpecial(s.substring(start + 1, i))}0")
                }
            }
        }
        return subStrs.sortedDescending().joinToString("")
    }

}