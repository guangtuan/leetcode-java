package tech.igrant.no210

import java.util.ArrayDeque

class Solution {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // 下标是课程的编号，元素是课程的依赖数
        val depCount = IntArray(numCourses)
        // 下标是课程的编号，元素是该课程被哪些课程所依赖
        val hasBeenDep = Array(numCourses) { mutableListOf<Int>() }
        // x 是课程，y 是前置课程
        for ((x, y) in prerequisites) {
            depCount[x]++
            hasBeenDep[y].add(x)
        }
        val q = ArrayDeque(IntArray(numCourses) { it }.filter { depCount[it] == 0 })
        val ordered = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val removed = q.removeFirst()
            ordered.add(removed)
            hasBeenDep[removed].forEach { x ->
                if (--depCount[x] == 0) {
                    q.add(x)
                }
            }
        }
        return if (ordered.size == numCourses) ordered.toIntArray() else intArrayOf()
    }

}