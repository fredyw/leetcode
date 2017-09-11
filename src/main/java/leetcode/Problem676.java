package leetcode;

/**
 * https://leetcode.com/problems/implement-magic-dictionary/
 */
public class Problem676 {
    static class MagicDictionary {
        private static class Node {
            private char ch;
            private boolean end;
            private Node[] children = new Node[26];

            public Node(char ch) {
                this.ch = ch;
            }

            @Override
            public String toString() {
                return "" + ch;
            }
        }

        private final Node root = new Node(' ');

        /** Initialize your data structure here. */
        public MagicDictionary() {
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String str : dict) {
                root.children[str.charAt(0) - 'a'] = build(str, 0, root);
            }
        }

        private static Node build(String str, int idx, Node node) {
            if (idx == str.length()) {
                return null;
            }
            Node n = node.children[str.charAt(idx) - 'a'];
            if (n == null) {
                n = new Node(str.charAt(idx));
                node.children[str.charAt(idx) - 'a'] = n;
            }
            Node m = build(str, idx + 1, n);
            if (m == null) {
                n.end = true;
            }
            return n;
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[]{"hello", "leetcode"});
        dict.search("hello"); // false
        dict.search("hhllo"); // true
        dict.search("hell"); // false
        dict.search("leetcode"); // false
    }
}
