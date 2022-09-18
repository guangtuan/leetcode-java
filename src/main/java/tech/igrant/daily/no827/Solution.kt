package tech.igrant.daily.no827

class Solution {

    private val left = Coordinates(0, -1)
    private val right = Coordinates(0, 1)
    private val up = Coordinates(-1, 0)
    private val down = Coordinates(1, 0)

    class Matrix(private val holder: Array<IntArray>) {
        operator fun get(coordinates: Coordinates): Int {
            return holder[coordinates.i][coordinates.j]
        }

        operator fun set(coordinates: Coordinates, value: Int) {
            holder[coordinates.i][coordinates.j] = value
        }

        fun n(): Int = holder.size
    }

    class Range(private val iMin: Int, private val iMax: Int, private val jMin: Int, private val jMax: Int) {
        operator fun contains(coordinates: Coordinates): Boolean =
            coordinates.i in iMin..iMax && coordinates.j in jMin..jMax

        override fun toString(): String = "i: [$iMin, $iMax], j: [$jMin, $jMax]"
    }

    class Coordinates(val i: Int, val j: Int) {
        operator fun plus(other: Coordinates): Coordinates {
            return Coordinates(i + other.i, j + other.j)
        }

        override fun toString(): String = "i: $i, j: $j"

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

    private fun findIsland(grid: Matrix, range: Range): Pair<List<Int>, Matrix> {
        val ret = Matrix(Array(grid.n()) { IntArray(grid.n()) { -1 } })
        val island = mutableListOf<Int>()
        for (i in 0 until grid.n()) {
            for (j in 0 until grid.n()) {
                // 这个点已经在岛屿上的，跳过
                val currCoordinates = Coordinates(i, j)
                if (ret[currCoordinates] != -1) {
                    continue
                }
                if (grid[currCoordinates] == 1) {
                    // 新建一个岛屿
                    island.add(1)
                    ret[currCoordinates] = island.size - 1
                    val access = mutableSetOf(currCoordinates)
                    // 深度搜索四个方向的相邻节点是否为1，如果是1，则加入岛屿，如果不是，停止搜索
                    search(left, currCoordinates, grid, island, ret, range, access)
                    search(right, currCoordinates, grid, island, ret, range, access)
                    search(up, currCoordinates, grid, island, ret, range, access)
                    search(down, currCoordinates, grid, island, ret, range, access)
                }
            }
        }
        return Pair(island, ret)
    }

    private fun search(dir: Coordinates, curr: Coordinates, grid: Matrix, island: MutableList<Int>, ret: Matrix, range: Range, access: MutableSet<Coordinates>) {
        val moved = curr + dir
        if (!access.add(moved)) {
            return
        }
        if (moved !in range) {
            return
        }
        if (grid[moved] != 1) {
            return
        }
        ret[moved] = island.size - 1
        island[island.size - 1]++
        search(left, moved, grid, island, ret, range, access)
        search(right, moved, grid, island, ret, range, access)
        search(up, moved, grid, island, ret, range, access)
        search(down, moved, grid, island, ret, range, access)
    }

    fun largestIsland(grid: Array<IntArray>): Int {
        // 先找出岛屿
        val matrixOrigin = Matrix(grid)
        val range = Range(iMin = 0, iMax = matrixOrigin.n() - 1, jMin = 0, jMax = matrixOrigin.n() - 1)
        val (areaByIslandCode, island) = findIsland(matrixOrigin, range)
        if (areaByIslandCode.isEmpty()) {
            return 1
        }
        var ans = areaByIslandCode[0]
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                val curr = grid[i][j]
                if (curr == 0) {
                    val tryToConnected = connect(Coordinates(i, j), island, areaByIslandCode, range)
                    if (ans < tryToConnected) {
                        ans = tryToConnected
                    }
                }
            }
        }
        return ans
    }

    private fun connect(curr: Coordinates, island: Matrix, areaByIslandCode: List<Int>, range: Range): Int {
        var ans = 1
        // 添加过的岛屿编号
        val added = mutableSetOf<Int>()
        for (nextDir in listOf(left, right, up, down)) {
            val nextCoordinates = curr + nextDir
            if (nextCoordinates !in range) continue
            if (island[nextCoordinates] == -1) continue
            val code = island[nextCoordinates]
            if (added.add(code)) {
                ans += areaByIslandCode[code]
            }
        }
        return ans
    }

}