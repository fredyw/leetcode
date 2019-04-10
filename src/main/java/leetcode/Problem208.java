package leetcode;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Problem208 {
    public static class Trie {
        private static class Node {
            private final Node[] children = new Node[26];
            private char value;
            private boolean complete;

            public Node() {
            }

            public Node(char value) {
                this.value = value;
            }
        }

        private final Node root = new Node();

        public Trie() {
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            insert(root, word, 0);
        }

        private static void insert(Node node, String word, int idx) {
            if (word.length() == idx) {
                node.complete = true;
                return;
            }
            char c = word.charAt(idx);
            Node n = node.children[c - 'a'];
            if (n == null) {
                n = new Node(c);
                node.children[c - 'a'] = n;
            }
            insert(n, word, idx + 1);
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private static boolean search(Node node, String word, int idx) {
            if (node == null) {
                return false;
            }
            if (word.length() == idx) {
                return node.complete;
            }
            char c = word.charAt(idx);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            Node n = node.children[c - 'a'];
            return search(n, word, idx + 1);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return startsWith(root, prefix, 0);
        }

        private boolean startsWith(Node node, String prefix, int idx) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == idx) {
                return true;
            }
            char c = prefix.charAt(idx);
            if (node.children[c - 'a'] == null) {
                return false;
            }
            Node n = node.children[c - 'a'];
            return startsWith(n, prefix, idx + 1);
        }
    }
}
