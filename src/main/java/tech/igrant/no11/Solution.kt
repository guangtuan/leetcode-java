package tech.igrant.no11


class Solution {

    fun maxArea(height: IntArray): Int {
        var i = 0
        var j = height.size - 1
        var max = 0
        while (i != j) {
            if (height[i] < height[j]) {
                max = max.coerceAtLeast((j - i) * height[i])
                i ++
            } else {
                max = max.coerceAtLeast((j - i) * height[j])
                j --
            }
        }
        return max
    }

}