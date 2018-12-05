package leetcode;

/**
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class Problem951 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem951 prob = new Problem951();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(8);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.left.right = new TreeNode(6);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);
        root2.right.right.left = new TreeNode(8);
        root2.right.right.right = new TreeNode(7);

        System.out.println(prob.flipEquiv(root1, root2)); // true
    }
}
