package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class Problem124 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public int maxPathSum(TreeNode root) {
        return 0;
    }

    public static void main(String[] args) {
        Problem124 prob = new Problem124();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(prob.maxPathSum(root)); // 6

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(prob.maxPathSum(root)); // 17

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(10);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(prob.maxPathSum(root)); // 22
    }
}
