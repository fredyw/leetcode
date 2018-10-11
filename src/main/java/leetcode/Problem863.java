package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 */
public class Problem863 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class TreeNodeIndex {
        private final int index;
        private final TreeNode node;

        public TreeNodeIndex(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode>[] graph = new List[501];
        buildGraph(root, null, graph);
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNodeIndex> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        queue.add(new TreeNodeIndex(0, target));
        visited[target.val] = true;
        while (!queue.isEmpty()) {
            TreeNodeIndex tni = queue.removeFirst();
            if (tni.index == K) {
                result.add(tni.node.val);
            } else if (tni.index > K) {
                break;
            }
            if (graph[tni.node.val] == null) {
                continue;
            }
            for (TreeNode adjacent : graph[tni.node.val]) {
                if (visited[adjacent.val]) {
                    continue;
                }
                queue.add(new TreeNodeIndex(tni.index + 1, adjacent));
                visited[adjacent.val] = true;
            }
        }
        return result;
    }

    private static void buildGraph(TreeNode node,
                                   TreeNode parent,
                                   List<TreeNode>[] graph) {
        if (node == null) {
            return;
        }
        add(graph, node, parent);
        add(graph, parent, node);
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    private static void add(List<TreeNode>[] graph, TreeNode from, TreeNode to) {
        if (from == null || to == null) {
            return;
        }
        if (graph[from.val] == null) {
            List<TreeNode> list = new ArrayList<>();
            list.add(to);
            graph[from.val] = list;
        } else {
            graph[from.val].add(to);
        }
    }
}
