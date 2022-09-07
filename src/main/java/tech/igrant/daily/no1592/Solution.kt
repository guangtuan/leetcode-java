package tech.igrant.daily.no1592

class Solution {

    private fun pad(size: Int): String = CharArray(size) { ' ' }.joinToString("")

    fun reorderSpaces(text: String): String {
        val word = text.split(" ").filter { it != "" }
        val space = text.length - word.map { it.length }.sum()
        if (word.size == 1) {
            return word[0] + pad(space)
        }
        val each = space / (word.size - 1)
        val last = space % (word.size - 1)
        return word.joinToString(pad(each)) + pad(last)
    }

}