package leetcode;

/**
 * https://leetcode.com/problems/path-sum/
 */
public class Problem112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0, !(root.left != null || root.right != null));
    }

    private boolean hasPathSum(TreeNode node, int sum, int accu, boolean isLeaf) {
        if (node == null) {
            if (accu == sum && isLeaf) {
                return true;
            } else {
                return false;
            }
        }
        boolean found1 = hasPathSum(node.left, sum, accu + node.val,
            !(node.left != null || node.right != null));
        boolean found2 = hasPathSum(node.right, sum, accu + node.val,
            !(node.left != null || node.right != null));
        return found1 || found2;
    }
}
