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
            String val1 = find(map, pair[0]);
            String val2 = find(map, pair[1]);
            if (!val1.equals(val2)) {
                map.put(val1, val2);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String word1 = words1[i];
            String word2 = words2[i];
            if (word1.equals(word2)) {
                continue;
            }
            String val1 = find(map, word1);
            String val2 = find(map, word2);
            if (val1 == null || val2 == null) {
                return false;
            }
            if (!val1.equals(val2)) {
                return false;
            }
        }
        return true;
    }

    private static String find(Map<String, String> map, String word) {
        String key = word;
        String value = map.get(key);
        if (value == null) {
            return null;
        }
        while (!key.equals(value)) {
            key = value;
            value = map.get(key);
        }
        return value;
    }
}
