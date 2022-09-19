package tech.igrant.daily.no827

class Solution {

    private val dirs = listOf(Coordinates(0, -1), Coordinates(0, 1), Coordinates(-1, 0), Coordinates(1, 0))

    class MatrixRange(override val start: Coordinates, override val endInclusive: Coordinates) : ClosedRange<Coordinates>, Iterable<Coordinates> {
        override fun contains(value: Coordinates): Boolean =
                value.i in start.i..endInclusive.i && value.j in start.j..endInclusive.j

        override fun iterator(): Iterator<Coordinates> {
            return It(endInclusive, start)
        }

        class It(private val endInclusive: Coordinates, start: Coordinates) : Iterator<Coordinates> {
            var next = start

            override fun hasNext(): Boolean {
                return next != Coordinates(endInclusive.i.inc(), 0)
            }

            override fun next(): Coordinates {
                val ret = Coordinates(next.i, next.j)
                next = if (ret.j < endInclusive.j) Coordinates(ret.i, ret.j.inc()) else Coordinates(ret.i.inc(), 0)
                return ret
            }
        }
    }

    class Matrix(private val holder: Array<IntArray>) {

        val indices: MatrixRange
            get() = MatrixRange(
                    start = Coordinates(i = 0, j = 0),
                    endInclusive = Coordinates(i = holder.size - 1, j = holder.size - 1)
            )

        operator fun get(coordinates: Coordinates): Int {
            return holder[coordinates.i][coordinates.j]
        }

        operator fun set(coordinates: Coordinates, value: Int) {
            holder[coordinates.i][coordinates.j] = value
        }

        fun n(): Int = holder.size

    }

    class Coordinates(val i: Int, val j: Int) : Comparable<Coordinates> {
        operator fun plus(other: Coordinates): Coordinates {
            return Coordinates(i + other.i, j + other.j)
        }

        override fun toString(): String = "i: $i, j: $j"
        override fun compareTo(other: Coordinates): Int {
            val iResult = this.i.compareTo(other.i)
            return if (iResult != 0) iResult else this.j.compareTo(other.j)
        }

        override fun equals(other: Any?): Boolean {
            if (other is Coordinates) {
                return this.i == other.i && this.j == other.j
            }
            return false
        }

        override fun hashCode(): Int {
            return toString().hashCode()
        }
    }

    private fun findIsland(grid: Matrix): Pair<List<Int>, Matrix> {
        val ret = Matrix(Array(grid.n()) { IntArray(grid.n()) { -1 } })
        val island = mutableListOf<Int>()
        for (currCoordinates in grid.indices) {
            // 这个点已经在岛屿上的，跳过
            if (ret[currCoordinates] != -1) {
                continue
            }
            if (grid[currCoordinates] == 1) {
                // 新建一个岛屿
                island.add(1)
                ret[currCoordinates] = island.size - 1
                val access = mutableSetOf(currCoordinates)
                // 深度搜索四个方向的相邻节点是否为1，如果是1，则加入岛屿，如果不是，停止搜索
                dirs.forEach { search(it, currCoordinates, grid, island, ret, access) }
            }
        }
        return Pair(island, ret)
    }

    private fun search(dir: Coordinates, curr: Coordinates, grid: Matrix, island: MutableList<Int>, ret: Matrix, accessed: MutableSet<Coordinates>) {
        val moved = curr + dir
        if (!accessed.add(moved)) {
            return
        }
        if (moved !in grid.indices) {
            return
        }
        if (grid[moved] != 1) {
            return
        }
        ret[moved] = island.size - 1
        island[island.size - 1]++
        dirs.forEach { search(it, moved, grid, island, ret, accessed) }
    }

    fun largestIsland(grid: Array<IntArray>): Int {
        // 先找出岛屿
        val matrixOrigin = Matrix(grid)
        val (areaByIslandCode, island) = findIsland(matrixOrigin)
        if (areaByIslandCode.isEmpty()) {
            return 1
        }
        var ans = areaByIslandCode[0]
        for (coordinates in matrixOrigin.indices) {
            if (matrixOrigin[coordinates] == 0) {
                val tryToConnected = connect(coordinates, island, areaByIslandCode)
                ans = ans.coerceAtLeast(tryToConnected)
            }
        }
        return ans
    }

    private fun connect(curr: Coordinates, island: Matrix, areaByIslandCode: List<Int>): Int {
        var ans = 1
        // 添加过的岛屿编号
        val added = mutableSetOf<Int>()
        for (nextDir in dirs) {
            val nextCoordinates = curr + nextDir
            if ((nextCoordinates !in island.indices) || (island[nextCoordinates] == -1)) continue
            with(island[nextCoordinates]) {
                if (added.add(this)) {
                    ans += areaByIslandCode[this]
                }
            }
        }
        return ans
    }

}