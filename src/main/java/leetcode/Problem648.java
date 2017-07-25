package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/replace-words/
 */
public class Problem648 {
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.add(word);
        }
        String[] words = sentence.split("\\s+");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String word : words) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(trie.get(word));
            i++;
        }
        return sb.toString();
    }

    private static class Node {
        private Character ch;
        private boolean isWord;
        private Node[] nodes = new Node[26];

        public Node(Character ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
        }
    }

    private static class Trie {
        private final Node[] nodes = new Node[26];

        public void add(String str) {
            add(str, 0, nodes);
        }

        private static void add(String str, int idx, Node[] nodes) {
            if (str.length() == idx) {
                return;
            }
            char c = str.charAt(idx);
            Node n = nodes[c - 'a'];
            if (n == null) {
                Node newNode = new Node(c, false);
                if (idx == str.length() - 1) {
                    newNode.isWord = true;
                }
                nodes[c - 'a'] = newNode;
            } else {
                if (idx == str.length() - 1) {
                    n.isWord = true;
                }
            }
            add(str, idx + 1, nodes[c - 'a'].nodes);
        }

        public String get(String str) {
            String s = get(str, 0, nodes);
            return (s == null) ? str : s;
        }

        private static String get(String str, int idx, Node[] nodes) {
            if (str.length() == idx) {
                return null;
            }
            char c = str.charAt(idx);
            Node n = nodes[c - 'a'];
            if (n == null) {
                return null;
            }
            if (n.isWord) {
                return str.substring(0, idx + 1);
            }
            return get(str, idx + 1, n.nodes);
        }
    }
}
