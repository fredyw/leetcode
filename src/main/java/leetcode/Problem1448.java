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
        return goodNodes(root, Integer.MIN_VALUE, true);
    }

    private static int goodNodes(TreeNode root, int parent, boolean good) {
        if (root == null) {
            return 0;
        }
        int val = (root.val > parent || (root.val == parent && good)) ? 1 : 0;
        if (root.val >= parent) {
            return goodNodes(root.left, root.val, true) +
                goodNodes(root.right, root.val, true) + val;
        }
        return goodNodes(root.left, root.val, false) +
            goodNodes(root.right, root.val, false) + val;
    }

    public static void main(String[] args) {
        Problem1448 prob = new Problem1448();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(prob.goodNodes(root)); // 4

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(prob.goodNodes(root)); // 3

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(prob.goodNodes(root)); // 3

        root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(3);
        System.out.println(prob.goodNodes(root)); // 4

        root = new TreeNode(1);
        System.out.println(prob.goodNodes(root)); // 1

        root = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        System.out.println(prob.goodNodes(root)); // 2
    }
}
