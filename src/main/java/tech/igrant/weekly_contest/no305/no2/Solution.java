package tech.igrant.weekly_contest.no305.no2;


import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 维护一个 int -> int[] 的索引，表示每个节点可以到达多少个节点
        // 从 0 开始遍历索引，深度优先
        Map<Integer, Set<Integer>> index = new HashMap<>();
        for (int[] edge : edges) {
            int left = edge[0];
            int right = edge[1];
            index.computeIfAbsent(left, absent -> new HashSet<>()).add(right);
            index.computeIfAbsent(right, absent -> new HashSet<>()).add(left);
        }
        Set<Integer> block = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
        Set<Integer> ret = new HashSet<>();
        access(index, Set.of(0), block, ret);
        return ret.size();
    }

    private void access(
            Map<Integer, Set<Integer>> all,
            Set<Integer> toAccess,
            Set<Integer> block,
            Set<Integer> holder
    ) {
        for (Integer access : toAccess) {
            if (block.contains(access)) {
                continue;
            }
            if (holder.contains(access)) {
                continue;
            }
            holder.add(access);
            Set<Integer> children = all.get(access);
            if (children != null) {
                access(all, children, block, holder);
            }
        }
    }

}
