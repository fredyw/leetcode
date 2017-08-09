package leetcode;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Problem653 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem653 prob = new Problem653();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(prob.findTarget(root, 9)); // true
        System.out.println(prob.findTarget(root, 28)); // false
    }
}
