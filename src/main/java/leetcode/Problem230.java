package leetcode;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class Problem230 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        IntRef ref = new IntRef();
        kthSmallest(root, k, ref);
        return ref.value;
    }

    private static class IntRef {
        private int value;
        private int n;
    }

    private void kthSmallest(TreeNode node, int k, IntRef ref) {
        if (node == null) {
            return;
        }
        kthSmallest(node.left, k, ref);
        ref.n++;
        if (ref.n == k) {
            ref.value = node.val;
            return;
        }
        kthSmallest(node.right, k, ref);
    }
}
