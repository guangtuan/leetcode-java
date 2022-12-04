package tech.igrant.daily.`find-nearest-point-that-has-the-same-x-or-y-coordinate`

import kotlin.math.abs

class Solution {

    class Point(
            private val x: Int,
            private val y: Int,
    ) {
        operator fun minus(point: Point): Int {
            if (point.x == this.x) {
                return abs(point.y - this.y)
            }
            if (point.y == this.y) {
                return abs(point.x - this.x)
            }
            throw IllegalArgumentException("不合法的计算")
        }

        fun same(point: Point): Boolean {
            return this.x == point.x || this.y == point.y
        }
    }

    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        val main = Point(x = x, y = y)
        return points.mapIndexed { index, ints -> index to Point(x = ints.first(), y = ints.last()) }
                .filter {
                    it.second.same(main)
                }
                .sortedBy {
                    val distance = it.second - main
                    if (distance == 0) {
                        it.first
                    }
                    distance
                }
                .firstOrNull()
                ?.first
                ?: -1
    }

}