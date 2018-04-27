package leetcode;

/**
 * https://leetcode.com/problems/short-encoding-of-words/
 */
public class Problem820 {
    public int minimumLengthEncoding(String[] words) {
        Node[] nodes = new Node[26];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int idx = word.length() - 1;
            char ch = word.charAt(idx);
            if (nodes[ch - 'a'] == null) {
                nodes[ch - 'a'] = new Node();
            }
            add(nodes[ch - 'a'], word, idx - 1);
        }
        int result = 0;
        for (Node node : nodes) {
            if (node != null) {
                PathCount pc = count(node);
                result += pc.path + pc.count;
            }
        }
        return result;
    }

    private static class PathCount {
        private final int path;
        private final int count;

        public PathCount(int path, int count) {
            this.path = path;
            this.count = count;
        }
    }

    private static PathCount count(Node node) {
        int count = 0;
        for (Node child : node.children) {
            if (child != null) {
                count++;
            }
        }
        if (count == 0) {
            return new PathCount(1, 1);
        }
        int totalPath = 0;
        int totalCount = 0;
        if (count > 0) {
            for (Node child : node.children) {
                if (child != null) {
                    PathCount pc = count(child);
                    totalPath += pc.path;
                    totalCount += pc.count;
                }
            }
        }
        return new PathCount(totalPath, totalCount + totalPath);
    }

    private static void add(Node node, String word, int idx) {
        if (idx < 0) {
            return;
        }
        char ch = word.charAt(idx);
        if (node.children[ch - 'a'] == null) {
            node.children[ch - 'a'] = new Node();
        }
        add(node.children[ch - 'a'], word, idx - 1);
    }

    private static class Node {
        private final Node[] children = new Node[26];
    }
}
