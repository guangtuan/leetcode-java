package tech.igrant.daily.no667

class Solution {

    fun constructArray(n: Int, k: Int): IntArray {
        // 10, 6 -> [1, (+6=)7, (-5=)2, (+4=)6, (-3=)3, (+2=)5, (-1=)4, 8,9,10]
        // 3, 2 -> [1, (+2=)3, (-1=)2]

        // 1,2,3,4,5,6,7,8,9,10
        // 3, 2 -> [1, 3, 2]
        //            2  1
        // 3, 1 -> [1,2,3]
        // 8, 7 -> [1, 8, 2, 7, 3, 6, 4, 5]
        //            7
        // 10, 5 -> [1,6,2,5,3,4,7,8,9,10]
        // 10, 4 -> [1,5,2,4,3,6,7,8,9,10]
        // 10, 3 -> [1,4,2,3,5,6,7,8,9,10]
        val ret = mutableListOf<Int>().also { it.add(1) }
        var init = k
        var flag = 1
        while (init != 0) {
            ret.add(last(ret) + flag * init)
            flag *= -1
            init -= 1
        }
        var init2 = k + 2
        while (ret.size < n) {
            ret.add(init2)
            init2 += 1
        }
        return ret.toIntArray()
    }

    private fun last(ret: MutableList<Int>) = ret[ret.size - 1]

}