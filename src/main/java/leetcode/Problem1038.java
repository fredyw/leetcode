package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem1038 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> sums = new ArrayList<>();
        traverse(root, sums);
        return bstToGst(root, sums, new IntRef());
    }

    private static TreeNode bstToGst(TreeNode root, List<Integer> sums, IntRef idx) {
        if (root == null) {
            return null;
        }
        root.left = bstToGst(root.left, sums, idx);
        root.val = sums.get(sums.size() - 1) - sums.get(idx.val) + root.val;
        idx.val++;
        root.right = bstToGst(root.right, sums, idx);
        return root;
    }

    private static class IntRef {
        private int val;
    }

    private static void traverse(TreeNode root, List<Integer> sums) {
        if (root == null) {
            return;
        }
        traverse(root.left, sums);
        if (sums.isEmpty()) {
            sums.add(root.val);
        } else {
            sums.add(sums.get(sums.size() - 1) + root.val);
        }
        traverse(root.right, sums);
    }

    public static void main(String[] args) {
        Problem1038 prob = new Problem1038();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        root = prob.bstToGst(root);
        System.out.println(root); // 30
        System.out.println(root.left); // 36
        System.out.println(root.left.left); // 36
        System.out.println(root.left.right); // 35
        System.out.println(root.left.right.right); // 33
        System.out.println(root.right); // 21
        System.out.println(root.right.left); // 26
        System.out.println(root.right.right); // 15
        System.out.println(root.right.right.right); // 8
    }
}
