package leetcode;

/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class Problem654 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private static TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int idx = max(nums, left, right);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = construct(nums, left, idx - 1);
        node.right = construct(nums, idx + 1, right);
        return node;
    }

    private static int max(int[] nums, int left, int right) {
        int idx = left;
        int max = 0;
        for (int i = left; i <= right; i++) {
            if (i == left) {
                max = nums[i];
            } else {
                if (max < nums[i]) {
                    max = nums[i];
                    idx = i;
                }
            }
        }
        return idx;
    }
}
