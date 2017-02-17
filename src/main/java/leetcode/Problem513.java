package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
        LinkedList<TreeNodeLevel> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        queue.add(new TreeNodeLevel(root, 1));
        int max = 0;
        while (!queue.isEmpty()) {
            TreeNodeLevel current = queue.remove();
            max = Math.max(max, current.level);
            if (!map.containsKey(current.level)) {
                List<Integer> list = new ArrayList<>();
                list.add(current.node.val);
                map.put(current.level, list);
            } else {
                map.get(current.level).add(current.node.val);
            }
            if (current.node.left != null) {
                queue.add(new TreeNodeLevel(current.node.left, current.level + 1));
            }
            if (current.node.right != null) {
                queue.add(new TreeNodeLevel(current.node.right, current.level + 1));
            }
        }
        return map.get(max).get(0);
    }

    private static class TreeNodeLevel {
        private final TreeNode node;
        private final int level;

        public TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
