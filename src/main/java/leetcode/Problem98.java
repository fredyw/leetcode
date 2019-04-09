package leetcode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Problem98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, new IntRef());
    }

    private static class IntRef {
        private Integer val;
    }

    private boolean inOrder(TreeNode node, IntRef ref) {
        if (node == null) {
            return true;
        }
        boolean a = inOrder(node.left, ref);
        if (ref.val != null) {
            if (ref.val >= node.val) {
                return false;
            }
        }
        ref.val = node.val;
        boolean b = inOrder(node.right, ref);
        return a & b;
    }
}
