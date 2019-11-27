package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class Problem1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node(' '); // dummy root
        for (String product : products) {
            root = build(root, product, 0);
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> words = new ArrayList<>();
            String sub = searchWord.substring(0, i + 1);
            Node node = get(root, sub, 0);
            if (node != null) {
                traverse(node, sub, words);
            }
            answer.add(words);
        }
        return answer;
    }

    private static class Node {
        private final char c;
        private final Node[] children = new Node[26];
        private boolean isWord;

        private Node(char c) {
            this.c = c;
        }
    }

    private static void traverse(Node node, String word, List<String> words) {
        if (node == null) {
            return;
        }
        if (words.size() == 3) {
            return;
        }
        if (node.isWord) {
            words.add(word);
        }
        for (Node child : node.children) {
            if (child != null) {
                traverse(child, word + child.c, words);
            }
        }
    }

    private static Node get(Node node, String searchWord, int index) {
        if (index == searchWord.length()) {
            return node;
        }
        char c = searchWord.charAt(index);
        Node child = node.children[c - 'a'];
        if (child == null) {
            return null;
        }
        return get(child, searchWord, index + 1);
    }

    private static Node build(Node node, String product, int index) {
        if (index == product.length()) {
            return node;
        }
        char c = product.charAt(index);
        Node child = node.children[c - 'a'];
        if (child == null) {
            child = new Node(c);
        }
        node.children[c - 'a'] = build(child, product, index + 1);
        if (index == product.length() - 1) {
            node.children[c - 'a'].isWord = true;
        }
        return node;
    }
}
