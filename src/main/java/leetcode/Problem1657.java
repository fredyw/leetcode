package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
public class Problem1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }
        List<Integer> counts1 = new ArrayList<>(map1.values());
        List<Integer> counts2 = new ArrayList<>(map2.values());
        Collections.sort(counts1);
        Collections.sort(counts2);
        return counts1.equals(counts2);
    }

    public static void main(String[] args) {
        Problem1657 prob = new Problem1657();
        System.out.println(prob.closeStrings("abc", "bca")); // true
        System.out.println(prob.closeStrings("a", "aa")); // false
        System.out.println(prob.closeStrings("cabbba", "abbccc")); // true
        System.out.println(prob.closeStrings("cabbba", "aabbss")); // false
        System.out.println(prob.closeStrings("ababc", "aaabc")); // false
        System.out.println(prob.closeStrings("cbbaa", "ccbba")); // true
        System.out.println(prob.closeStrings("caabbb", "abbccc")); // true
        System.out.println(prob.closeStrings("uau", "ssx")); // false
    }
}
