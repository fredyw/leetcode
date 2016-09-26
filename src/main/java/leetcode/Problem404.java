package leetcode;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class Problem404 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem404 prob = new Problem404();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(prob.sumOfLeftLeaves(root));
    }
}
