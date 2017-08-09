package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */
public class Problem653 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        findTarget(root, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey();
            Integer count = map.get(k - val);
            if (count != null) {
                if (val == k - val && count >= 2) {
                    return true;
                } else if (val != k - val) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void findTarget(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root.val)) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, map.get(root.val) + 1);
        }
        findTarget(root.left, map);
        findTarget(root.right, map);
    }
}
