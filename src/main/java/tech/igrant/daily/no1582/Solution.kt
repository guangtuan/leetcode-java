package tech.igrant.daily.no1582

class Solution {

    fun numSpecial(mat: Array<IntArray>): Int {
        val rowSum = IntArray(mat.size) { 0 }
        val colSum = IntArray(mat[0].size) { 0 }
        mat.forEachIndexed { i, eachRow ->
            eachRow.forEachIndexed { j, cell ->
                rowSum[i] += cell
                colSum[j] += cell
            }
        }
        return mat.mapIndexed { i, eachRow ->
            eachRow.filterIndexed { j, cell ->
                cell == 1 && rowSum[i] == 1 && colSum[j] == 1
            }
        }.map { it.size }.sum()
    }

}