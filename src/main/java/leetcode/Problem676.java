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
            return search(word, 0, root, true, true);
        }

        private static boolean search(String word, int idx, Node node, boolean same, boolean allSame) {
            if (idx == word.length()) {
                return false;
            }
            boolean found = false;
            if (same) {
                for (int i = 0; i < node.children.length; i++) {
                    Node n = node.children[i];
                    if (n == null || n.ch == word.charAt(idx)) {
                        continue;
                    }
                    if (n.end && !allSame) {
                        return true;
                    }
                    found |= search(word, idx + 1, n, false, allSame & false);
                }
            }
            Node n = node.children[word.charAt(idx) - 'a'];
            if (n != null) {
                if (n.end && !allSame) {
                    return true;
                }
                found |= search(word, idx + 1, n, same, allSame & true);
            }
            return found;
        }
    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[]{"hello", "leetcode", "judgg"});
        System.out.println(dict.search("hello")); // false
        System.out.println(dict.search("hhllo")); // true
        System.out.println(dict.search("hell")); // false
        System.out.println(dict.search("helxa")); // false
        System.out.println(dict.search("leetcode")); // false
        System.out.println(dict.search("leetkode")); // true
        System.out.println(dict.search("liitcode")); // false
        System.out.println(dict.search("xeetcode")); // true
        System.out.println(dict.search("guggg")); // false
        System.out.println(dict.search("leetcodd")); // true
        System.out.println(dict.search("hella")); // true
    }
}
