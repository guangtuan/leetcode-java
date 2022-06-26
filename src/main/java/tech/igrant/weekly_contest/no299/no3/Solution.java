package tech.igrant.weekly_contest.no299.no3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(
                get(nums1, nums2),
                get(nums2, nums1)
        );
    }

    private int get(int[] nums1, int[] nums2) {
        List<Integer> delta = new ArrayList<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            delta.add(nums1[i] - nums2[i]);
        }
        Integer maxSubListSum = maxSubListSum(delta);
        return Arrays.stream(nums2).sum() + maxSubListSum;
    }


    // 这里，如何求最大的子数组的和，很关键
    private Integer maxSubListSum(List<Integer> delta) {
        int maxSum = 0;
        for (int i = 0, s = 0; i < delta.size(); i++) {
            s = Math.max(s + delta.get(i), 0);
            maxSum = Math.max(maxSum, s);
        }
        return maxSum;
    }

}
