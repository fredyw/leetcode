package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/kill-process/#/description
 */
public class Problem582 {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<>();
        result.add(kill);
        Map<Integer, Node> tree = buildTree(pid, ppid);
        kill(tree.get(kill), result);
        return result;
    }

    private static void kill(Node node, List<Integer> result) {
        for (Node n : node.children) {
            result.add(n.pid);
            kill(n, result);
        }
    }

    private static Map<Integer, Node> buildTree(List<Integer> pid, List<Integer> ppid) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int parent = ppid.get(i);
            int child = pid.get(i);

            Node parentNode = null;
            if (!map.containsKey(parent)) {
                parentNode = new Node(parent);
                map.put(parent, parentNode);
            } else {
                parentNode = map.get(parent);
            }

            Node childNode = null;
            if (!map.containsKey(child)) {
                childNode = new Node(child);
                map.put(child, childNode);
            } else {
                childNode = map.get(child);
            }
            parentNode.children.add(childNode);
        }
        return map;
    }

    private static class Node {
        private final int pid;
        private List<Node> children = new ArrayList<>();

        public Node(int pid) {
            this.pid = pid;
        }
    }
}
