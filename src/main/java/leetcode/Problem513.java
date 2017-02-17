package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class Problem513 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        IntRef max = new IntRef();
        Map<Integer, List<Integer>> map = new HashMap<>();
        findBottomLeftValue(root, 1, max, map);
        return map.get(max.ref).get(0);
    }

    private static class IntRef {
        private int ref;
    }

    private static void findBottomLeftValue(TreeNode node, int level, IntRef max,
                                            Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        max.ref = Math.max(max.ref, level);
        if (!map.containsKey(level)) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            map.put(level, list);
        } else {
            map.get(level).add(node.val);
        }
        findBottomLeftValue(node.left, level + 1, max, map);
        findBottomLeftValue(node.right, level + 1, max, map);
    }
}
