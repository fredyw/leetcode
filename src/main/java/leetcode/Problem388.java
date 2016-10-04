package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
public class Problem388 {
    public int lengthLongestPath(String input) {
        String[] split = input.split("\\n");
        Map<Integer, Node> levelNodes = new HashMap<>();
        List<Node> roots = new ArrayList<>();
        for (String s : split) {
            int idx = 0;
            int currentLevel = 0;
            while (s.charAt(idx++) == '\t') {
                currentLevel++;
            }
            boolean file = s.contains(".");
            Node node = new Node(s.length() - currentLevel, file);
            if (currentLevel > 0) {
                Node parent = levelNodes.get(currentLevel - 1);
                parent.children.add(node);
            } else {
                roots.add(node);
            }
            levelNodes.put(currentLevel, node);
        }
        return max(roots);
    }

    private static int max(List<Node> roots) {
        int max = 0;
        for (Node root : roots) {
            max = Math.max(max, max(root, root.length));
        }
        return max;
    }

    private static int max(Node root, int accu) {
        if (root.children.isEmpty()) {
            if (root.file) {
                return accu;
            }
            return 0;
        }
        int m = 0;
        for (Node child : root.children) {
            m = Math.max(m, max(child, accu + child.length + 1));
        }
        return m;
    }

    private static class Node {
        private final int length;
        private final boolean file;
        private final List<Node> children = new ArrayList<>();

        public Node(int length, boolean file) {
            this.length = length;
            this.file = file;
        }
    }
}
