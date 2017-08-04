package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class Problem652 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> result = new ArrayList<>();
        Map<String, List<NodeString>> map = new HashMap<>();
        build(root.left, map, result);
        build(root.right, map, result);
        return result;
    }

    private static class NodeString {
        private final TreeNode node;
        private final String string;

        public NodeString(TreeNode node, String string) {
            this.node = node;
            this.string = string;
        }
    }

    private static NodeString build(TreeNode node, Map<String, List<NodeString>> map, List<TreeNode> result) {
        if (node == null) {
            return new NodeString(node, "");
        }
        NodeString left = build(node.left, map, result);
        NodeString right = build(node.right, map, result);
        String string = left.string + "," + right.string + "," + node.val;
        NodeString current = new NodeString(node, string);
        if (map.containsKey(string)) {
            List<NodeString> nodes = map.get(string);
            nodes.add(current);
            if (nodes.size() == 2) {
                result.add(current.node);
            }
        } else {
            List<NodeString> nodes = new ArrayList<>();
            nodes.add(current);
            map.put(string, nodes);
        }
        return current;
    }
}
