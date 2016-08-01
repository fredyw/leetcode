package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class Problem211 {
    public static class WordDictionary {
        private Node root = new Node();

        private static class Node {
            char ch;
            boolean done;
            Map<Character, Node> children = new HashMap<>();

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

        private void addWord(Node node, String word, int idx) {
            if (idx == word.length()) {
                node.done = true;
                return;
            }
            char ch = word.charAt(idx);
            Node n;
            if (node.children.containsKey(ch)) {
                n = node.children.get(ch);
            } else {
                n = new Node(ch, false);
                node.children.put(ch, n);
            }
            addWord(n, word, idx + 1);
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node node, String word, int idx) {
            if (idx == word.length()) {
                return node.done;
            }
            char ch = word.charAt(idx);
            if (!node.children.containsKey(ch)) {
                if (ch == '.') {
                    boolean found = false;
                    for (Map.Entry<Character, Node> e : node.children.entrySet()) {
                        found |= search(e.getValue(), word, idx + 1);
                    }
                    return found;
                }
                return false;
            }
            Node n = node.children.get(ch);
            return search(n, word, idx + 1);
        }
    }
}
