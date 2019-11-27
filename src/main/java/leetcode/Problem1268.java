package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class Problem1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // TODO
        return null;
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
        System.out.println(prob.suggestedProducts(
            new String[]{"havana"}, "havana")); // [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
        System.out.println(prob.suggestedProducts(
            new String[]{"bags","baggage","banner","box","cloths"}, "bags")); // [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
        System.out.println(prob.suggestedProducts(
            new String[]{"havana"}, "tatiana")); // [[],[],[],[],[],[],[]]
    }
}
