package leetcode;

/**
 * https://leetcode.com/problems/delete-leaves-with-a-given-value/
 */
public class Problem1325 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1325 prob = new Problem1325();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);

        System.out.println(prob.removeLeafNodes(root, 2));
    }
}
