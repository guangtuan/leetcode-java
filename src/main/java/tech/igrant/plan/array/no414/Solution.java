package tech.igrant.plan.array.no414;

import java.util.HashSet;
import java.util.Set;

class Solution {

    private boolean lt(Integer no1, Integer no2) {
        if (no2 == null) {
            return true;
        }
        return no1 > no2;
    }

    public int thirdMax(int[] nums) {
        Integer no1 = null;
        Integer no2 = null;
        Integer no3 = null;
        Set<Integer> acc = new HashSet<>();
        for (int num : nums) {
            if (acc.add(num)) {
                if (lt(num, no1)) {
                    no3 = no2;
                    no2 = no1;
                    no1 = num;
                } else if (lt(num, no2)) {
                    no3 = no2;
                    no2 = num;
                } else if (lt(num, no3)) {
                    no3 = num;
                }
            }
        }
        return no3 == null ? no1 : no3;
    }

}
