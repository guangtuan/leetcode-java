package tech.igrant.weekly_contest.no310.no3

import java.util.PriorityQueue

class Solution {

    fun minGroups(intervals: Array<IntArray>): Int {
        // 输入
        //  [[5,10],[6,8],[1,5],[2,3],[1,10]]
        // 按照 start 排序
        // [1,5], [1,10], [2,3], [5,10], [6,8]

        // 添加过程
        // [1,5] 空的，直接加入
        // [1,5] [1,10] 重叠，无法合并，变成两个分组
        // check: [2, 3] 无法加入 [1,5], 也无法加入 [1,10] // 2比5小，更比10小，最小的加不上，其他的不用考虑
        // [2,3],[1,5],[1,10]
        // [1,5] [1,10] [2,10]
        // [1,8] [1,10] [2,10]
        // 能不能加，只和每个分组里的元素的 end 有关系

        // 新的 [start,end] 只要往 end 最小的已有分组上加（= 合并），加不上，则不加
        // 已有分组按照 end 为标准放进最小堆，每次加元素都有可能改变这个最小值
        val q = PriorityQueue<IntArray> { o1, o2 -> o1[1].compareTo(o2[1]) }
        val sorted = intervals.sortedBy { it[0] }
        for (ele in sorted) {
            if (q.isEmpty()) {
                q.add(ele)
            } else {
                if (ele[0] <= q.peek()[1]) {
                    // 无法合并
                    q.add(ele)
                } else {
                    // 合并 start 必然是前一个比较小，end 必然是后一个比较大
                    // [1, 3], [4, 5] -> [1, 5]
                    q.offer(intArrayOf(q.poll()[0], ele[1]))
                }
            }
        }
        return q.size
    }

    fun minGroups2(intervals: Array<IntArray>): Int {
        // 题目可以转化为
        // 每个 intervals -> [start, end]
        // 有一个大区间 [min(start), max(end)]  // 这个区间可以从题目范围 0 到 10**6，也可以从输入计算得来（数组 size 会小一些）
        // 以这个区间构造数组
        // 遍历 intervals -> 往 [start, end] 的位置叠加 1
        // 叠加完的最大元素，就是所求区间的数量

        // 差分数组
        // 按照数据范围
        val (max, min) = maxAndMin(intervals)
        val diff = IntArray(max - min + 1) { 0 }
        // 要给区间 [start, end] 都 +1，则 diff[start] +=1, diff[end + 1] -= 1
        // 按照差分数组的定义，diff[start] 的 + delta 会向后传递，所以 diff[end + 1] (不是 diff[-1] 的时候) 要相应的减去 delta
        for ((start, end) in intervals) {
            diff[start - min] += 1
            val stop = end + 1 - min
            if (stop < diff.size) {
                diff[stop] -= 1
            }
        }
        var curr = diff[0]
        var result = diff[0]
        // 从 diff 还原成数组
        for (i in 1 until diff.size) {
            curr += diff[i]
            result = result.coerceAtLeast(curr)
        }
        return result
    }

    private fun maxAndMin(intervals: Array<IntArray>): Pair<Int, Int> {
        var max = intervals[0][0]
        var min = intervals[0][1]
        for ((start, end) in intervals) {
            if (start < min) min = start
            if (end > max) max = end
        }
        return Pair(max, min)
    }

}