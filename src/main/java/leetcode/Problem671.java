package leetcode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class Problem671 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem671 prob = new Problem671();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(prob.findSecondMinimumValue(root)); // 5

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(prob.findSecondMinimumValue(root)); // -1
    }
}
