package leetcode;

/**
 * https://leetcode.com/problems/map-sum-pairs/
 */
public class Problem677 {
    private static class MapSum {
        private static class Node {
            private final char ch;
            private final Node[] nodes = new Node[26];
            private boolean end;
            private int value;

            public Node(char ch) {
                this.ch = ch;
            }
        }

        private final Node[] root = new Node[26];

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
        }

        public void insert(String key, int val) {
            insert(key, val, 0, root);
        }

        private static void insert(String key, int val, int idx, Node[] nodes) {
            if (idx == key.length()) {
                return;
            }
            Node n = nodes[key.charAt(idx) - 'a'];
            if (n == null) {
                n = new Node(key.charAt(idx));
                nodes[key.charAt(idx) - 'a'] = n;
            }
            if (idx == key.length() - 1) {
                n.value = val;
                n.end = true;
            }
            insert(key, val, idx + 1, n.nodes);
        }

        public int sum(String prefix) {
            return sum(prefix, 0, root);
        }

        private static int sum(String prefix, int idx, Node[] nodes) {
            if (idx == prefix.length()) {
                return sum(nodes);
            }
            Node n = nodes[prefix.charAt(idx) - 'a'];
            if (n == null) {
                return 0;
            }
            int val = 0;
            if (idx == prefix.length() - 1 && nodes[prefix.charAt(idx) - 'a'].end) {
                val = nodes[prefix.charAt(idx) - 'a'].value;
            }
            return sum(prefix, idx + 1, n.nodes) + val;
        }

        private static int sum(Node[] nodes) {
            int total = 0;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] != null) {
                    int val = 0;
                    if (nodes[i].end) {
                        val = nodes[i].value;
                    }
                    total += sum(nodes[i].nodes) + val;
                }
            }
            return total;
        }
    }
}
