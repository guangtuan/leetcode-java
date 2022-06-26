package tech.igrant.weekly_contest.no299.no1;

class Solution {

    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            int[] line = grid[i];
            int len = line.length;
            int x = len - i - 1;
            for (int j = 0; j < line.length; j++) {
                if (j == x || j == len - x - 1) {
                    if (line[j] == 0) {
                        return false;
                    }
                } else {
                    if (line[j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
