package leetcode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class Problem654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem654 prob = new Problem654();
        System.out.println(prob.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
