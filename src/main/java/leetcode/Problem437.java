package leetcode;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class Problem437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem437 prob = new Problem437();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(4);

        System.out.println(prob.pathSum(root, 8)); // 3
    }
}
