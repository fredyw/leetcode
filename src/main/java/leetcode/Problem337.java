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
    }

    public int rob(TreeNode root) {
        Map<Integer, Integer> memo = new HashMap<>();
        int a = rob(root, 0, 0, 0, memo);
        int b1 = rob(root.left, 0, 0, 0, memo);
        int b2 = rob(root.right, 0, 0, 0, memo);
        int b = b1 + b2;
        return Math.max(a, b);
    }

    private int rob(TreeNode node, int idx, int step, int targetStep, Map<Integer, Integer> memo) {
        if (node == null) {
            return 0;
        }
        int val = 0;
        int newStep = step;
        if (step == targetStep) {
            val = node.val;
            newStep = 0;
        }
        int leftIdx = idx + 1;
        int left1 = rob(node.left, leftIdx, newStep + 1, 2, memo);
        int left2 = rob(node.left, leftIdx, newStep + 1, 3, memo);
        int maxLeft = Math.max(left1, left2);

        int rightIdx = idx + 2;
        int right1 = rob(node.right, rightIdx, newStep + 1, 2, memo);
        int right2 = rob(node.right, rightIdx, newStep + 1, 3, memo);
        int maxRight = Math.max(right1, right2);

        int max = maxLeft + maxRight;
        return max + val;
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
    }
}
