package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/description/
public class Problem742 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findClosestLeaf(TreeNode root, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> leaves = new HashSet<>();
        buildGraph(root, graph, leaves);
        Answer answer = new Answer();
        findClosestLeaf(graph, leaves, new HashSet<>(), k, 0, answer);
        return answer.node;
    }

    private static class Answer {
        int length;
        int node;
    }

    private static void findClosestLeaf(Map<Integer, List<Integer>> graph,
                                        Set<Integer> leaves,
                                        Set<Integer> visited, int k, int length,
                                        Answer answer) {
        if (leaves.contains(k)) {
            if (answer.node == 0) {
                answer.length = length;
                answer.node = k;
            } else if (answer.length > length) {
                answer.length = length;
                answer.node = k;
            }
        }
        visited.add(k);
        var children = graph.get(k);
        for (int child : children) {
            if (visited.contains(child)) {
                continue;
            }
            findClosestLeaf(graph, leaves, visited, child, length + 1, answer);
        }
    }

    private static void buildGraph(TreeNode root, Map<Integer, List<Integer>> graph,
                                   Set<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        if (!graph.containsKey(root.val)) {
            graph.put(root.val, new ArrayList<>());
        }
        if (root.left != null) {
            addToGraph(graph, root.val, root.left.val);
        }
        if (root.right != null) {
            addToGraph(graph, root.val, root.right.val);
        }
        buildGraph(root.left, graph, leaves);
        buildGraph(root.right, graph, leaves);
    }

    private static void addToGraph(Map<Integer, List<Integer>> graph, int a, int b) {
        var children = graph.getOrDefault(a, new ArrayList<>());
        children.add(b);
        graph.put(a, children);

        children = graph.getOrDefault(b, new ArrayList<>());
        children.add(a);
        graph.put(b, children);
    }
}
