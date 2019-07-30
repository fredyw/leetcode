package leetcode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
public class Problem1123 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1123 prob = new Problem1123();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root = prob.lcaDeepestLeaves(root);
        System.out.println(root); // 1
        System.out.println(root.left); // 2
        System.out.println(root.right); // 3


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root = prob.lcaDeepestLeaves(root);
        System.out.println(root); // 4

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root = prob.lcaDeepestLeaves(root);
        System.out.println(root); // 2
        System.out.println(root.left); // 4
        System.out.println(root.right); // 5
    }
}
