package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class Problem1302 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        IntRef maxLevel = new IntRef();
        Map<Integer, Integer> levelSum = new HashMap<>();
        deepestLeavesSum(root, 0, maxLevel, levelSum);
        return levelSum.get(maxLevel.value);
    }

    private static class IntRef {
        private int value;
    }

    private static void deepestLeavesSum(TreeNode root, int level, IntRef maxLevel,
                                         Map<Integer, Integer> levelSum) {
        if (root == null) {
            return;
        }
        maxLevel.value = Math.max(maxLevel.value, level);
        if (root.left == null && root.right == null) {
            if (!levelSum.containsKey(level)) {
                levelSum.put(level, root.val);
            } else {
                levelSum.put(level, levelSum.get(level) + root.val);
            }
            return;
        }
        deepestLeavesSum(root.left, level + 1, maxLevel, levelSum);
        deepestLeavesSum(root.right, level + 1, maxLevel, levelSum);
    }
}
