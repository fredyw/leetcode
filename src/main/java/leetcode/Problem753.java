package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/open-the-lock/description/
 */
public class Problem753 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String dead : deadends) {
            deads.add(dead);
        }
        Set<String> visited = new HashSet<>();
        Queue<NodeDepth> queue = new LinkedList<>();
        queue.add(new NodeDepth("0000", 0));
        while (!queue.isEmpty()) {
            NodeDepth current = queue.remove();
            if (deads.contains(current.node)) {
                continue;
            }
            if (current.node.equals(target)) {
                return current.level;
            }
            for (NodeDepth neighbor : getNeighbors(current)) {
                if (!visited.contains(neighbor.node)) {
                    queue.add(neighbor);
                    visited.add(neighbor.node);
                }
            }
        }
        return -1;
    }

    private static class NodeDepth {
        private final String node;
        private final int level;

        public NodeDepth(String node, int depth) {
            this.node = node;
            this.level = depth;
        }
    }

    private static List<NodeDepth> getNeighbors(NodeDepth nodeDepth) {
        List<NodeDepth> neighbors = new ArrayList<>();
        for (int i = 0; i < nodeDepth.node.length(); i++) {
            int n1 = (nodeDepth.node.charAt(i) - '0' - 1) % 10;
            if (n1 < 0) {
                n1 = 9;
            }
            neighbors.add(new NodeDepth(
                nodeDepth.node.substring(0, i) + n1 + nodeDepth.node.substring(i + 1),
                nodeDepth.level + 1));
            int n2 = (nodeDepth.node.charAt(i) - '0' + 1) % 10;
            neighbors.add(new NodeDepth(
                nodeDepth.node.substring(0, i) + n2 + nodeDepth.node.substring(i + 1),
                nodeDepth.level + 1));
        }
        return neighbors;
    }
}
