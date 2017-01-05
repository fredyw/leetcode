package leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class Problem450 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem450 prob = new Problem450();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root = prob.deleteNode(root, 3);
    }
}
