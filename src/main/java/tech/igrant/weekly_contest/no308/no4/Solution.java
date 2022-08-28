package tech.igrant.weekly_contest.no308.no4;

import java.util.*;

class Solution {


    Map<Integer, Integer> indexOf(int[][] pairs, int k) {
        //
        
        return new HashMap<>();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Map<Integer, Integer> row = indexOf(rowConditions, k);
        Map<Integer, Integer> col = indexOf(colConditions, k);
        int[][] ret = new int[k][k];
        row.forEach((value, indexOfRow) -> {
            Integer indexOfCol = col.get(value);
            ret[indexOfRow][indexOfCol] = value;
        });
        return ret;
    }

}
