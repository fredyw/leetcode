package leetcode;

/**
 * https://leetcode.com/problems/equal-tree-partition/
 */
public class Problem663 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean checkEqualTree(TreeNode root) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem663 prob = new Problem663();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(prob.checkEqualTree(root)); // true

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(20);
        System.out.println(prob.checkEqualTree(root)); // false
    }
}
