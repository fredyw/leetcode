package leetcode;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Problem1022 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1022 prob = new Problem1022();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        System.out.println(prob.sumRootToLeaf(root)); // 22
    }
}
