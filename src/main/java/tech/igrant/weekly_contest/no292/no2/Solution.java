package tech.igrant.weekly_contest.no292.no2;

import java.util.*;

class Solution {

    // 000 actual 1 exp 3

    public int averageOfSubtree(TreeNode root) {
        // 获取 sub tree 的和，以及 sub tree 的个数
        // fsum(root) = fsum(root.left) + fsum(root.right) + root.val;
        // fcount(root) = fcount(root.left) + fcount(root.right) + 1;
        List<Integer> sumMap = new ArrayList<>();
        List<Integer> countMap = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        sum(root, sumMap, vals);
        count(root, countMap, vals);
        System.out.println(sumMap);
        System.out.println(countMap);
        int ret = 0;
        for (int i = 0; i < vals.size(); i++) {
            int val = vals.get(i);
            int sum = sumMap.get(i);
            int count = countMap.get(i);
            if (count == 0) {
                if (sum == 0) {
                    ret += 1;
                }
            } else {
                int ava = sum / count;
                if (ava == val) {
                    ret += 1;
                }
            }
        }
        return ret;
    }

    private int sum(TreeNode node, List<Integer> sumMap, List<Integer> vals) {
        if (node == null) {
            return 0;
        }
        int sum = node.val + sum(node.left, sumMap, vals) + sum(node.right, sumMap, vals);
        vals.add(node.val);
        sumMap.add(sum);
        return sum;
    }

    private int count(TreeNode node, List<Integer> countMap, List<Integer> vals) {
        if (node == null) {
            return 0;
        }
        int count = 1 + count(node.left, countMap, vals) + count(node.right, countMap, vals);
        countMap.add(count);
        return count;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
