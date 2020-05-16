package leetcode;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class Problem1448 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1448 prob = new Problem1448();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        System.out.println(prob.goodNodes(root)); // 4

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(prob.goodNodes(root)); // 3

        root = new TreeNode(1);
        System.out.println(prob.goodNodes(root)); // 1
    }
}
