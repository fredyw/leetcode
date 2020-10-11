package leetcode;

/**
 * https://leetcode.com/problems/prefix-and-suffix-search/
 */
public class Problem745 {
    static class WordFilter {
        private final Node[] nodes = new Node[27]; // extra one char for separator

        private static class Node {
            private int weight;
            private final Node[] children = new Node[27]; // extra one char for separator
        }

        public WordFilter(String[] words) {
            int weight = 0;
            for (String word : words) {
                for (int i = word.length(); i >= 0; i--) {
                    // We choose '{' because it's a character after z.
                    String newWord = word.substring(i) + "{" + word;
                    int index = 0;
                    Node node = nodes[newWord.charAt(index) - 'a'];
                    if (node == null) {
                        node = new Node();
                        nodes[newWord.charAt(index) - 'a'] = node;
                    }
                    node.weight = weight;
                    insert(newWord, index + 1, node);
                }
                weight++;
            }
        }

        public int f(String prefix, String suffix) {
            String word = suffix + "{" + prefix;
            int index = 0;
            Node node = nodes[word.charAt(index) - 'a'];
            if (node == null) {
                return -1;
            }
            return search(word, index + 1, node);
        }

        private static void insert(String word, int i, Node node) {
            if (i == word.length()) {
                return;
            }
            Node child = node.children[word.charAt(i) - 'a'];
            if (child == null) {
                child = new Node();
                node.children[word.charAt(i) - 'a'] = child;
            }
            child.weight = node.weight;
            insert(word, i + 1, child);
        }

        private static int search(String word, int i, Node node) {
            if (i == word.length()) {
                return node.weight;
            }
            Node child = node.children[word.charAt(i) - 'a'];
            if (node == null) {
                return -1;
            }
            return search(word, i + 1, child);
        }
    }

    public static void main(String[] args) {
        WordFilter wf = new WordFilter(new String[]{"apple", "facebook", "fakebook"});
        System.out.println(wf.f("a", "e")); // 0
        System.out.println(wf.f("fa", "ook")); // 1

//        WordFilter wf = new WordFilter(new String[]{
//            "cabaabaaaa","ccbcababac","bacaabccba","bcbbcbacaa","abcaccbcaa","accabaccaa","cabcbbbcca","ababccabcb","caccbbcbab","bccbacbcba"
//        });
//        System.out.println(wf.f("bccbacbcba","a")); // 9
//        System.out.println(wf.f("ab","abcaccbcaa")); // 4
//        System.out.println(wf.f("a","aa")); // 5
    }
}
