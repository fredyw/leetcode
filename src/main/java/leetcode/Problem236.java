package leetcode;

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
        LCA lca = new LCA();
        lowestCommonAncestor(root, p, q, lca);
        return lca.node;
    }

    private static class LCA {
        private TreeNode node;
    }

    private static boolean lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q,
                                                LCA lca) {
        if (root == null) {
            return false;
        }
        boolean mid = false;
        if (root.val == p.val || root.val == q.val) {
            mid = true;
        }
        boolean left = lowestCommonAncestor(root.left, p, q, lca);
        boolean right = lowestCommonAncestor(root.right, p, q, lca);
        if ((mid && left) || (mid && right) || (left && right)) {
            if (lca.node == null) {
                lca.node = root;
            }
        }
        return left | mid | right;
    }
}
