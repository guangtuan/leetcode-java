package tech.igrant.daily.no667

class Solution {

    fun constructArray(n: Int, k: Int): IntArray {
        // 1,2,3,4,5,6,7,8,9,10
        // 10, 7 -> [1,7,2,6,3,5,4,8,9,10]
        // 10, 5 -> [1,6,2,5,3,4,7,8,9,10]
        // 10, 4 -> [1,5,2,4,3,6,7,8,9,10]
        // 10, 3 -> [1,4,2,3,5,6,7,8,9,10]
        val ret = mutableListOf<Int>()
        var i = 1
        var j = 1 + k
        while (true) {
            ret.add(i++)
            ret.add(j--)
            if (i == j) {
                ret.add(i)
                break
            } else if (i > j) {
                break
            }
        }
        var end = 1 + k + 1
        while (ret.size < n) {
            ret.add(end++)
        }
        return ret.toIntArray()
    }

}