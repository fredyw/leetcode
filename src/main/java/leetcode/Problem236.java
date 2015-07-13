package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class Problem236 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> path1 = getPath(root, p);
        Stack<TreeNode> path2 = getPath(root, q);
        int minSize = Math.min(path1.size(), path2.size());
        TreeNode lca = null;
        for (int i = 0; i < minSize; i++) {
            TreeNode node1 = path1.pop();
            TreeNode node2 = path2.pop();
            if (node1.val != node2.val) {
                break;
            } else {
                lca = node1;
            }
        }
        return lca;
    }
    
    private Stack<TreeNode> getPath(TreeNode root, TreeNode n) {
        if (root == null) {
            return null;
        }
        if (root == n) {
            Stack<TreeNode> path = new Stack<>();
            path.add(root);
            return path;
        }
        Stack<TreeNode> result = getPath(root.left, n);
        if (result != null) {
            result.add(root);
            return result;
        }
        result = getPath(root.right, n);
        if (result != null) {
            result.add(root);
            return result;
        }
        return result;
    }
}
