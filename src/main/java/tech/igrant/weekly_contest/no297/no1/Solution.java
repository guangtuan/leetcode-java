package tech.igrant.weekly_contest.no297.no1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public double calculateTax(int[][] brackets, int income) {
        int remain = income;
        double ret = 0;
        List<List<Integer>> cals = getLists(brackets, income);
        for (List<Integer> cal : cals) {
            int up = cal.get(0);
            int ratio = cal.get(1);
            if (remain > 0) {
                if (remain > up) {
                    ret += up * ratio / 100d;
                } else {
                    ret += remain * ratio / 100d;
                }
                remain = remain - up;
            } else {
                break;
            }
        }
        return ret;
    }

    private List<List<Integer>> getLists(int[][] brackets, int income) {
        List<List<Integer>> cals = new ArrayList<>();
        cals.add(Arrays.asList(brackets[0][0], brackets[0][1]));
        for (int i = 1; i < brackets.length; i++) {
            int[] prev = brackets[i - 1];
            int[] curr = brackets[i];
            if (income < prev[0]) {
                return cals;
            }
            int val = curr[0] - prev[0];
            cals.add(Arrays.asList(val, curr[1]));
        }
        return cals;
    }

}
