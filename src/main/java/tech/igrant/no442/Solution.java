package tech.igrant.no442;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int mod = nums.length + 1;
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i] % mod;
            nums[curr - 1] += mod;
            if (nums[curr - 1] / mod == 2) {
                ret.add(curr);
            }
        }
        return ret;
    }
}