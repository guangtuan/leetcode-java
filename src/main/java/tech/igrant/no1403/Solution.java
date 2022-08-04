package tech.igrant.no1403;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

}
