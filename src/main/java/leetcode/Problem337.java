package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class Problem337 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("val=").append(val);
            sb.append('}');
            return sb.toString();
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Map<String, Integer> memo = new HashMap<>();
        int a = rob(root, false, memo);
        int b = rob(root, true, memo);
//        System.out.println("a: " + a + " vs b: " + b);
        return Math.max(a, b);
    }

    private int rob(TreeNode node, boolean skipped, Map<String, Integer> memo) {
        if (node == null) {
            return 0;
        }
        int max;
        if (skipped) {
            int left1 = rob(node.left, skipped, memo); // continue skipping
            int left2 = rob(node.left, !skipped, memo); // start processing
            int maxLeft = Math.max(left1, left2);

            int right1 = rob(node.right, skipped, memo); // continue skipping
            int right2 = rob(node.right, !skipped, memo); // start processing
            int maxRight = Math.max(right1, right2);

            max = maxLeft + maxRight;
        } else { // not skipped
            int maxLeft = rob(node.left, !skipped, memo); // start skipping
            int maxRight = rob(node.right, !skipped, memo); // start skipping
            max = maxLeft + maxRight;
        }
        if (!skipped) {
            max += node.val;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem337 prob = new Problem337();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(prob.rob(root)); // 7

        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(1);
        System.out.println(prob.rob(root)); // 9

        root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        System.out.println(prob.rob(root)); // 7

        root = new TreeNode(3);
        System.out.println(prob.rob(root)); // 3

        root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(prob.rob(root)); // 4

        root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(prob.rob(root)); // 7
    }
}
