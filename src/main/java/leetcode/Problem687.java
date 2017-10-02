package leetcode;

/**
 * https://leetcode.com/problems/longest-univalue-path/
 */
public class Problem687 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        IntRef intRef = new IntRef();
        longestUnivaluePath(root, intRef);
        return intRef.val - 1;
    }

    private static class IntRef {
        private int val;
    }

    private ValCount longestUnivaluePath(TreeNode root, IntRef ref) {
        if (root == null) {
            return null;
        }
        ValCount left = longestUnivaluePath(root.left, ref);
        ValCount right = longestUnivaluePath(root.right, ref);
        int count = 1;
        if (left != null) {
            if (root.val == left.val) {
                count += left.count;
            }
        }
        if (right != null) {
            if (root.val == right.val) {
                count += right.count;
            }
        }
        ref.val = Math.max(ref.val, count);
        return new ValCount(root.val, count);
    }

    private static class ValCount {
        private final int val;
        private final int count;

        public ValCount(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Problem687 prob = new Problem687();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(prob.longestUnivaluePath(root)); // 2

        root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(prob.longestUnivaluePath(root)); // 2

        root = new TreeNode(1);
        System.out.println(prob.longestUnivaluePath(root)); // 0
    }
}
