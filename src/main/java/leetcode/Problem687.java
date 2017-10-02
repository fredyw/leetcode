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

    private static class ValCount {
        private final int val;
        private final int count;

        public ValCount(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    private ValCount longestUnivaluePath(TreeNode root, IntRef ref) {
        if (root == null) {
            return null;
        }
        ValCount left = longestUnivaluePath(root.left, ref);
        ValCount right = longestUnivaluePath(root.right, ref);
        if (left != null && right != null && left.val == right.val && left.val == root.val) {
            ref.val = Math.max(ref.val, left.count + right.count + 1);
            return new ValCount(root.val, Math.max(left.count, right.count) + 1);
        }
        if (left != null) {
            if (root.val == left.val) {
                ref.val = Math.max(ref.val, left.count + 1);
                return new ValCount(root.val, left.count + 1);
            }
        }
        if (right != null) {
            if (root.val == right.val) {
                ref.val = Math.max(ref.val, right.count + 1);
                return new ValCount(root.val, right.count + 1);
            }
        }
        ref.val = Math.max(ref.val, 1);
        return new ValCount(root.val, 1);
    }
}
