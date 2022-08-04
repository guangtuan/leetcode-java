package tech.igrant.no226;

import tech.igrant.TreeNode;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ret = new TreeNode(root.val);
        ret.right = invertTree(root.left);
        ret.left = invertTree(root.right);
        return ret;
    }

}
