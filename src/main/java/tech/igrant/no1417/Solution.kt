package tech.igrant.no1417

class Solution {

    fun reformat(s: String): String {
        val (a, b) = s.partition { c -> c.isDigit() }.toList().sortedByDescending { it.length }
        return if (a.length - b.length > 1) ""
        else a.zip(b).joinToString("") { p -> "${p.first}${p.second}" } + if (a.length != b.length) a.last() else ""
    }

}