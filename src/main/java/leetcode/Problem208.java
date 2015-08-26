package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Problem208 {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        char value;
        boolean complete;
        
        // Initialize your data structure here.
        public TrieNode() {
        }
        
        public TrieNode(char value) {
            this.value = value;
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            insert(root, word, 0);
        }
        
        private void insert(TrieNode node, String word, int idx) {
            if (word.length() == idx) {
                node.complete = true;
                return;
            }
            char c = word.charAt(idx);
            TrieNode n;
            if (node.children.containsKey(c)) {
                n = node.children.get(c);
            } else {
                n = new TrieNode(c);
                node.children.put(c, n);
            }
            insert(n, word, idx+1);
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            return search(root, word, 0);
        }
        
        private boolean search(TrieNode node, String word, int idx) {
            if (node == null) {
                return false;
            }
            if (word.length() == idx) {
                if (node.complete) {
                    return true;
                }
                return false;
            }
            char c = word.charAt(idx);
            if (!node.children.containsKey(c)) {
                return false;
            }
            TrieNode n = node.children.get(c);
            return search(n, word, idx+1);
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            return startsWith(root, prefix, 0);
        }
        
        private boolean startsWith(TrieNode node, String prefix, int idx) {
            if (node == null) {
                return false;
            }
            if (prefix.length() == idx) {
                return true;
            }
            char c = prefix.charAt(idx);
            if (!node.children.containsKey(c)) {
                return false;
            }
            TrieNode n = node.children.get(c);
            return startsWith(n, prefix, idx+1);
        }
    }
}
