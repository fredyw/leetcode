package leetcode;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Problem208 {
    static class TrieNode {
        // Initialize your data structure here.
        public TrieNode() {
            
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            // TODO: implement this
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            // TODO: implement this
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            // TODO: implement this
            return false;
        }
    }
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("something");
        System.out.println(trie.search("something"));
        System.out.println(trie.search("some"));
        System.out.println(trie.search("blah"));
        System.out.println(trie.startsWith("some"));
        System.out.println(trie.startsWith("foo"));
    }
}
