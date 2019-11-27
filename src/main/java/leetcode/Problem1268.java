package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class Problem1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node(' ');
        for (String product : products) {
            root = build(root, product, 0);
        }
        return null;
    }

    private static class Node {
        private final char c;
        private final Node[] children = new Node[26];
        private boolean isWord;

        private Node(char c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "" + c;
        }
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

    public static void main(String[] args) {
        Problem1268 prob = new Problem1268();
        // [["mobile","moneypot","monitor"],
        //  ["mobile","moneypot","monitor"],
        //  ["mouse","mousepad"],
        //  ["mouse","mousepad"],
        //  ["mouse","mousepad"]]
        System.out.println(prob.suggestedProducts(
            new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
//        System.out.println(prob.suggestedProducts(
//            new String[]{"havana"}, "havana")); // [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
//        System.out.println(prob.suggestedProducts(
//            new String[]{"bags","baggage","banner","box","cloths"}, "bags")); // [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
//        System.out.println(prob.suggestedProducts(
//            new String[]{"havana"}, "tatiana")); // [[],[],[],[],[],[],[]]
    }
}
