package leetcode;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class Problem513 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem513 prob = new Problem513();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(prob.findBottomLeftValue(root)); // 1

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        System.out.println(prob.findBottomLeftValue(root)); // 7
    }
}
