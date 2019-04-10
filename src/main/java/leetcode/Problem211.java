package leetcode;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class Problem211 {
    public static class WordDictionary {
        private final Node root = new Node();

        private static class Node {
            private char ch;
            private boolean done;
            private final Node[] children = new Node[26];

            public Node() {
            }

            public Node(char ch, boolean done) {
                this.ch = ch;
                this.done = done;
            }
        }

        // Adds a word into the data structure.
        public void addWord(String word) {
            addWord(root, word, 0);
        }

        private static void addWord(Node node, String word, int idx) {
            if (idx == word.length()) {
                node.done = true;
                return;
            }
            char ch = word.charAt(idx);
            Node n = node.children[ch - 'a'];
            if (n == null) {
                n = new Node(ch, false);
                node.children[ch - 'a'] = n;
            }
            addWord(n, word, idx + 1);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private static boolean search(Node node, String word, int idx) {
            if (idx == word.length()) {
                return node.done;
            }
            char ch = word.charAt(idx);
            if (ch == '.') {
                boolean found = false;
                for (Node child : node.children) {
                    if (child == null) {
                        continue;
                    }
                    found |= search(child, word, idx + 1);
                }
                return found;
            }
            if (node.children[ch - 'a'] == null) {
                return false;
            }
            Node n = node.children[ch - 'a'];
            return search(n, word, idx + 1);
        }
    }
}
