package tech.igrant.no713;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    List<List<Integer>> part(Set<String> failMap, int step, int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> curr = new ArrayList<>();
            boolean fail = false;
            for (int j = 0; j < step; j++) {
                if (i + j == nums.length) {
                    return ret;
                }
                curr.add(nums[i + j]);
                if (!failMap.isEmpty()) {
                    if (failMap.contains(curr.stream().map(Objects::toString).collect(Collectors.joining(",")))) {
                        fail = true;
                        break;
                    }
                }
            }
            if (!fail) {
                ret.add(curr);
            }
        }
        return ret;
    }

    private boolean match(List<Integer> nums, int k) {
//        System.out.println("start match to k " + k);
//        System.out.println(nums);
//        System.out.println("start ----->");
        int product = 1;
        for (Integer num : nums) {
            product = product * num;
            if (product >= k) {
                return false;
            }
        }
        return true;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        Set<String> failMap = new HashSet<>();
        for (int step = 1; step <= nums.length; step++) {
            List<List<Integer>> parted = part(failMap, step, nums);
            int tmp = 0;
//            System.out.println(parted);
            for (List<Integer> integers : parted) {
                boolean match = match(integers, k);
                if (match) {
                    tmp += 1;
                } else {
                    failMap.add(integers.stream().map(Objects::toString).collect(Collectors.joining(",")));
                }
            }
            ret += tmp;
        }
        return ret;
    }

}
