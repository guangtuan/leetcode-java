package tech.igrant.weekly_contest.no308.no1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private record WithIndex(int index, int val) {
    }

    private WithIndex last(List<WithIndex> list) {
        return list.get(list.size() - 1);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        // 排序
        // 挨个取
        Arrays.sort(nums);
        List<WithIndex> prefix = new ArrayList<>();
        prefix.add(new WithIndex(0, 0));
        for (int i = 0; i < nums.length; i++) {
            prefix.add(new WithIndex(i + 1, last(prefix).val + nums[i]));
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            WithIndex found = find(queries[i], prefix);
            ans[i] = found.index;
        }
        return ans;
    }

    private WithIndex find(int query, List<WithIndex> prefix) {
        WithIndex pre = null;
        for (WithIndex withIndex : prefix) {
            if (query >= withIndex.val) {
                pre = withIndex;
            } else {
                return pre;
            }
        }
        return pre;
    }

}
