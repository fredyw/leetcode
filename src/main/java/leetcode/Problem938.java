package leetcode;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class Problem938 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem938 prob = new Problem938();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);
        System.out.println(prob.rangeSumBST(root, 7, 15)); // 32
        System.out.println(prob.rangeSumBST(root, 6, 15)); // 32

        root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        System.out.println(prob.rangeSumBST(root, 6, 10)); // 23
    }
}
