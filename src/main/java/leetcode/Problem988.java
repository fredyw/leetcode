package leetcode;

/**
 * https://leetcode.com/problems/smallest-string-starting-from-leaf/
 */
public class Problem988 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        String left = smallestFromLeaf(root.left);
        String right = smallestFromLeaf(root.right);
        String val = "";
        if (!left.isEmpty()) {
            val = left;
        } else if (!right.isEmpty()) {
            val = right;
        }
        if (!left.isEmpty() && !right.isEmpty()) {
            if (left.compareTo(right) <= 0) {
                val = left;
            } else {
                val = right;
            }
        }
        return val + (char) (root.val + 'a');
    }
}
