package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/sentence-similarity/
 */
public class Problem734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                Set<String> set = new HashSet<>();
                set.add(pair[1]);
                map.put(pair[0], set);
            } else {
                map.get(pair[0]).add(pair[1]);
            }
            if (!map.containsKey(pair[1])) {
                Set<String> set = new HashSet<>();
                set.add(pair[0]);
                map.put(pair[1], set);
            } else {
                map.get(pair[1]).add(pair[0]);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            if (!map.containsKey(word1)) {
                return false;
            }
            Set<String> set = map.get(word1);
            if (!set.contains(word2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem734 prob = new Problem734();
        System.out.println(prob.areSentencesSimilar(
            new String[]{"great", "acting", "skills"},
            new String[]{"fine","drama","talent"},
            new String[][]{{"great", "fine"}, {"acting","drama"}, {"skills","talent"}}
        )); // true
        System.out.println(prob.areSentencesSimilar(
            new String[]{"great", "acting", "skills"},
            new String[]{"fine","drama","talent"},
            new String[][]{{"great", "fine"}, {"acting","drama"}}
        )); // false
        System.out.println(prob.areSentencesSimilar(
            new String[]{"great", "acting", "skills"},
            new String[]{"great","acting","skills"},
            new String[][]{}
        )); // true
    }
}
