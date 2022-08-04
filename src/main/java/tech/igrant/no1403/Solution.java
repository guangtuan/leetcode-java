package tech.igrant.no1403;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int num : nums) {
            q.add(num);
            sum += num;
        }
        int newSum = 0;
        PriorityQueue<Integer> ret = new PriorityQueue<>(Comparator.reverseOrder());
        while(newSum <= (sum - newSum)) {
            int polled = q.poll();
            newSum += polled;
            ret.add(polled);
        }
        return new ArrayList<>(ret);
    }

    public List<Integer> minSubsequence2(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int sum = 0;
        for (Integer integer : sorted) {
            sum += integer;
        }
        int newSum = 0;
        List<Integer> ret = new ArrayList<>();
        while (newSum <= (sum - newSum)) {
            Integer removed = sorted.remove(0);
            ret.add(removed);
            newSum += removed;
        }
        return ret;
    }

}
