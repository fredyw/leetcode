package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Problem987 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<YValue>> map = new TreeMap<>();
        verticalTraversal(root, 0, 0, map);
        List<List<Integer>> answer = new ArrayList<>();
        map.forEach((key, value) -> {
            Collections.sort(value, (a, b) -> {
                int cmp = Integer.compare(b.y, a.y);
                if (cmp == 0) {
                    return Integer.compare(a.value, b.value);
                }
                return cmp;
            });
            List<Integer> sub = new ArrayList<>();
            for (YValue v : value) {
                sub.add(v.value);
            }
            answer.add(sub);
        });
        return answer;
    }

    private static class YValue {
        private final int y;
        private final int value;

        public YValue(int y, int value) {
            this.y = y;
            this.value = value;
        }
    }

    private static void verticalTraversal(TreeNode root, int x, int y,
                                          Map<Integer, List<YValue>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new YValue(y, root.val));
        verticalTraversal(root.left, x - 1, y - 1, map);
        verticalTraversal(root.right, x + 1, y - 1, map);
    }
}
