package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sentence-similarity-ii/
 */
public class Problem737 {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (String[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], pair[0]);
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], pair[1]);
            }
            if (!find(map, pair[0]).equals(find(map, pair[1]))) {
                map.put(pair[0], pair[1]);
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
            if (!map.containsKey(word2)) {
                return false;
            }
            if (!find(map, word1).equals(find(map, word2))) {
                return false;
            }
        }
        return true;
    }

    private static String find(Map<String, String> map, String word) {
        String key = word;
        String value = map.get(key);
        while (!key.equals(value)) {
            key = value;
            value = map.get(key);
        }
        return value;
    }

    public static void main(String[] args) {
        Problem737 prob = new Problem737();
        System.out.println(prob.areSentencesSimilarTwo(
            new String[]{"great", "acting", "skills"},
            new String[]{"fine", "drama", "talent"},
            new String[][]{{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}}
        )); // true
        System.out.println(prob.areSentencesSimilarTwo(
            new String[]{"great"},
            new String[]{"great"},
            new String[][]{}
        )); // true
        System.out.println(prob.areSentencesSimilarTwo(
            new String[]{"great"},
            new String[]{"fine"},
            new String[][]{{"great", "good"}, {"fine", "good"}}
        )); // true
        System.out.println(prob.areSentencesSimilarTwo(
            new String[]{"great"},
            new String[]{"great", "blah"},
            new String[][]{}
        )); // false
    }
}
