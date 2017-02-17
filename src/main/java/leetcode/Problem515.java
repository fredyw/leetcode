package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class Problem515 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        largestValues(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            result.add(map.get(i));
        }
        return result;
    }

    private static void largestValues(TreeNode node, int level,
                                      Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, node.val);
        } else {
            map.put(level, Math.max(map.get(level), node.val));
        }
        largestValues(node.left, level + 1, map);
        largestValues(node.right, level + 1, map);
    }
}
