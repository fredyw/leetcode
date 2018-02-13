package leetcode;

/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class Problem783 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDiffInBST(TreeNode root) {
        Result result = new Result();
        inOrder(root, result);
        return result.min;
    }

    private static class Result {
        private Integer min;
        private Integer value;
    }

    private static void inOrder(TreeNode root, Result result) {
        if (root == null) {
            return;
        }
        inOrder(root.left, result);
        if (result.value == null) {
            result.value = root.val;
        } else {
            int diff = Math.abs(result.value - root.val);
            if (result.min == null) {
                result.min = diff;
            } else {
                result.min = Math.min(result.min, diff);
            }
            result.value = root.val;
        }
        inOrder(root.right, result);
    }
}
