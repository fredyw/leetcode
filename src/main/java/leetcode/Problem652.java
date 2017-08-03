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

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<String, NodeString> left = new HashMap<>();
        build(root.left, left);
        Map<String, NodeString> right = new HashMap<>();
        build(root.right, right);
        List<TreeNode> result = new ArrayList<>();
        for (Map.Entry<String, NodeString> entry : left.entrySet()) {
            if (right.containsKey(entry.getKey())) {
                result.add(entry.getValue().node);
            }
        }
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

    private static NodeString build(TreeNode node, Map<String, NodeString> map) {
        if (node == null) {
            return new NodeString(node, "");
        }
        NodeString left = build(node.left, map);
        NodeString right = build(node.right, map);
        String string = left.string + "," + right.string + "," + node.val;
        NodeString current = new NodeString(node, string);
        map.put(string, current);
        return current;
    }

    public static void main(String[] args) {
        Problem652 prob = new Problem652();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        System.out.println(prob.findDuplicateSubtrees(root)); // [[2,4,5],[4],[5]]

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(prob.findDuplicateSubtrees(root)); // [[2,4],[4]]

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        System.out.println(prob.findDuplicateSubtrees(root)); // [[2,2],[2]]
    }
}
