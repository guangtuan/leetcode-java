package tech.igrant.weekly_contest.no322.no3

class Solution {

    class Node(
            val id: Int,
            // id to point
            val next: MutableList<Pair<Int, Int>>
    )

    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val nodes = mutableMapOf<Int, Node>()
        for (road in roads) {
            val a = road[0]
            val b = road[1]
            val point = road[2]
            nodes[a] = (nodes[a] ?: Node(a, mutableListOf()))
                    .apply {
                        this.next.add(b to point)
                    }
            nodes[b] = (nodes[b] ?: Node(b, mutableListOf()))
                    .apply {
                        this.next.add(a to point)
                    }
        }
        // 建立一棵树完成
        // 深度优先搜索
        // 查找能够从 1 到 n 的路径
        val nNode = nodes[n]!!
        val resHolder = intArrayOf(Int.MAX_VALUE)
        val access = mutableSetOf<Int>()
        dfs(nodes, nNode, resHolder, access)
        return resHolder[0]
    }

    private fun dfs(nodes: Map<Int, Node>, nNode: Node, resHolder: IntArray, access: MutableSet<Int>) {
        if (!access.add(nNode.id)) {
            return
        }
        for (pair in nNode.next) {
            if (pair.second < resHolder[0]) {
                resHolder[0] = pair.second
            }
            nodes[pair.first]?.let {
                dfs(nodes, it, resHolder, access)
            }
        }
    }

}