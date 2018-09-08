package leetcode;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class Problem897 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNodeRef ref = new TreeNodeRef();
        increasingBST(root, ref);
        return ref.root;
    }

    private static class TreeNodeRef {
        private TreeNode root;
        private TreeNode node;
    }

    private static void increasingBST(TreeNode node, TreeNodeRef ref) {
        if (node == null) {
            return;
        }
        increasingBST(node.left, ref);
        node.left = null;
        if (ref.root == null) {
            ref.root = node;
            ref.node = node;
        } else {
            ref.node.right = node;
            ref.node = node;
        }
        increasingBST(node.right, ref);
    }
}
