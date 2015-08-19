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

    private static class Result {
        int n;
        int val;
        boolean found;
    }
    
    public int kthSmallest(TreeNode root, int k) {
        Result result = new Result();
        kthSmallest(root, k, result);
        return result.val;
    }
    
    private void kthSmallest(TreeNode node, int k, Result result) {
        if (result.n == k) {
            result.found = true;
            return;
        }
        if (node == null) {
            return;
        }
        kthSmallest(node.left, k, result);
        result.n++;
        if (!result.found) {
            result.val = node.val;
        }
        kthSmallest(node.right, k, result);
    }
}
