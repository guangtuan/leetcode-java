package tech.igrant.no496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> lookup = produceLookup2(nums2);
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            ret[i] = lookup.getOrDefault(curr, -1);
        }
        return ret;
    }

    private Map<Integer, Integer> produceLookup2(int[] num2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = num2.length - 1; i >= 0; i--) {
            int curr = num2[i];
            while (!stack.isEmpty() && curr >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                lookup.put(curr, stack.peek());
            }
            stack.push(curr);
        }
        return lookup;
    }

    private Map<Integer, Integer> produceLookup(int[] nums2) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums2.length - 1; i++) {
            int result = getResult(nums2, i);
            if (result != -1) {
                lookup.put(nums2[i], result);
            }
        }
        return lookup;
    }

    private int getResult(int[] nums2, int i) {
        int dest = i + 1;
        while (dest <= nums2.length - 1) {
            if (nums2[dest] > nums2[i]) {
                return nums2[dest];
            }
            dest++;
        }
        return -1;
    }

}
