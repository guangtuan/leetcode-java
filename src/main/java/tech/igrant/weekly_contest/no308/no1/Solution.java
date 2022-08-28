package tech.igrant.weekly_contest.no308.no1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private Integer last(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        // 排序
        // 挨个取
        Arrays.sort(nums);
        List<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        for (int num : nums) {
            prefix.add(last(prefix) + num);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = find(queries[i], prefix);
        }
        return ans;
    }

    private int find(int query, List<Integer> prefix) {
        int ans = 0;
        for (int i = 0; i < prefix.size(); i++) {
            if (query >= prefix.get(i)) {
                ans = i;
            } else {
                return ans;
            }
        }
        return ans;
    }

}
