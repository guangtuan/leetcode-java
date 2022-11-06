package tech.igrant.weekly_contest.no318.no2

class Solution {

    class QSet(
            private var size: Int
    ) {
        // 只记录 i, j, sum, 以及所有的元素最后一次出现的 index
        // 加入的时候，通过 index 判断是否存在该元素
        private val indexMap = mutableMapOf<Int, Int>()
        private var i = 0
        private var j = 0
        private var sum = 0L

        fun getSum(): Long {
            return sum
        }

        fun print(nums: IntArray) {
            val r = IntRange(start = i, endInclusive = j)
            println("[$i, $j], sum is $sum, each ele is ${nums.slice(r)}")
        }

        fun valid(): Boolean {
            return (j - i + 1) == size
        }

        fun add(nums: IntArray, j: Int) {
            if (indexMap.containsKey(nums[j])) {
                val newI = indexMap[nums[j]]!! + 1
                val toRemoveKeys = mutableSetOf<Int>()
                indexMap.forEach { (value, idxInArray) ->
                    if (idxInArray < newI) {
                        toRemoveKeys.add(value)
                    }
                }
                this.i = newI
                for (toRemoveKey in toRemoveKeys) {
                    sum -= toRemoveKey
                    indexMap.remove(toRemoveKey)
                }
                this.j = j
                sum += nums[j]
                indexMap[nums[j]] = j
            } else {
                if (indexMap.size == size) {
                    this.i += 1
                    findToRemove(i - 1) ?.let {
                        sum -= it.first
                        indexMap.remove(it.first)
                    }
                }
                this.j = j
                sum += nums[j]
                indexMap[nums[j]] = j
            }
        }

        private fun findToRemove(i: Int): Pair<Int, Int>? {
            for (entry in indexMap.entries) {
                if (entry.value == i) {
                    return entry.key to entry.value
                }
            }
            return null
        }
    }

    fun maximumSubarraySum(nums: IntArray, k: Int): Long {
        var ret = 0L
        // 滑动窗口，size 为 k
        // 窗口右侧加入元素，左侧移出元素 -> 队列
        // 窗口内的元素不能重复，否则为不符合条件，set
        // 循环结束的条件是，窗口右侧触碰到了数组的右侧，也就是 j == nums.size - 1
        val qSet = QSet(size = k)
        for (i in nums.indices) {
            qSet.add(nums, i)
//            qSet.print(nums)
            if (qSet.valid()) {
                if (ret < qSet.getSum()) {
                    ret = qSet.getSum()
                }
            }
        }
        return ret
    }

}