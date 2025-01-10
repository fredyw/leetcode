package leetcode;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/description/
public class Problem1644 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA lca = new LCA();
        lowestCommonAncestor(root, p, q, lca);
        return lca.node;
    }

    private static class LCA {
        private TreeNode node;
    }

    private boolean lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, LCA lca) {
        if (root == null) {
            return false;
        }
        boolean parent = root.val == p.val || root.val == q.val;
        boolean left = lowestCommonAncestor(root.left, p, q, lca);
        boolean right = lowestCommonAncestor(root.right, p, q, lca);
        if (parent || (left && right)) {
            lca.node = root;
            return true;
        }
        return left || right;
    }
}
