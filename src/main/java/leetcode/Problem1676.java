package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/
public class Problem1676 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        LCA lca = new LCA();
        lowestCommonAncestor(root, nodes, lca);
        return lca.node;
    }

    private static class LCA {
        private TreeNode node;
    }

    private static boolean lowestCommonAncestor(TreeNode root, TreeNode[] nodes, LCA lca) {
        if (root == null) {
            return false;
        }
        var parent = Arrays.stream(nodes).anyMatch(node -> node.val == root.val);
        var left = lowestCommonAncestor(root.left, nodes, lca);
        var right = lowestCommonAncestor(root.right, nodes, lca);
        return parent || left || right;
    }
}
