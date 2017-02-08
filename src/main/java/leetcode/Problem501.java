package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 */
public class Problem501 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class IntRef {
        int val;
    }

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        IntRef max = new IntRef();
        findMode(root, map, max);
        List<Integer> list = new ArrayList<>();
        map.forEach((val, count) -> {
            if (count == max.val) {
                list.add(val);
            }
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void findMode(TreeNode node, Map<Integer, Integer> map, IntRef max) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(node.val)) {
            if (max.val < 1) {
                max.val = 1;
            }
            map.put(node.val, 1);
        } else {
            int newCount = map.get(node.val) + 1;
            if (max.val < newCount) {
                max.val = newCount;
            }
            map.put(node.val, newCount);
        }
        findMode(node.left, map, max);
        findMode(node.right, map, max);
    }
}
