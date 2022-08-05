package tech.igrant.no623;

import tech.igrant.TreeNode;

import java.util.LinkedList;

/**
 * depth = 1，加在 0 和 1 之间，level[0].appended.left = level[0].left / right 同理
 * depth = 2，加在 1 和 2 之间
 * depth = 3，加在 2 和 3 之间
 * depth = 4，加在 3 和 4 之间
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (depth > 2) {
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode curr = q.pollFirst();
                if (curr.left != null) {
                    q.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                }
            }
            depth--;
        }
        for (TreeNode treeNode : q) {
            treeNode.left = new TreeNode(val, treeNode.left, null);
            treeNode.right = new TreeNode(val, null, treeNode.right);
        }
        return root;
    }
}
