package tech.igrant.weekly_contest.no317.no2

class Solution {

    fun mostPopularCreator(creators: Array<String>, ids: Array<String>, views: IntArray): List<List<String>> {
        fun idJoin(s1: String, s2: String): String {
            return "${s1}___${s2}"
        }
        val viewMap = ids.mapIndexed { index, s -> (idJoin(s, creators[index])) to views[index] }.associate { it }
        val zip = creators.zip(ids).groupBy { it.first }
                .mapValues {ele ->
                    val creator = ele.key
                    val value = ele.value
                    value.map { p -> p.second to viewMap[idJoin(p.second, creator)] }
                }
                .mapValues {e ->
                    val sumArray = e.value.mapNotNull { e1 -> e1.second }
                    var ret = 0
                    sumArray.forEach { s -> ret += s }
                    ret to e.value
                }
        val sorted = zip.entries.sortedByDescending {
            it.value.first
        }
        val max = sorted[0]
        val maxValue = sorted[0].value.first
        val ret = mutableListOf<List<String>>()
        ret.add(listOf(max.key, s(max)))
        for (i in 1 until sorted.size) {
            val curr = sorted[i]
            if (curr.value.first == maxValue) {
                ret.add(listOf(curr.key, s(curr)))
            } else {
                break
            }
        }
        return ret
    }

    private fun s(max: Map.Entry<String, Pair<Int, List<Pair<String, Int?>>>>) =
            max.value.second.sortedWith(Comparator<Pair<String, Int?>> { o1, o2 ->
                val n1 = o1.second ?: 0
                val n2 = o2.second ?: 0
                n2.compareTo(n1)
            }.thenComparing { o1, o2 -> o1.first.compareTo(o2.first) }).map { it.first }.first()

}