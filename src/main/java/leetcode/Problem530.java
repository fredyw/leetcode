package leetcode;

/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class Problem530 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int getMinimumDifference(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem530 prob = new Problem530();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        System.out.println(prob.getMinimumDifference(root)); // 1
    }
}
