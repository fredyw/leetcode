package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class Problem72 {
    public int minDistance(String word1, String word2) {
        Map<String, Integer> memo = new HashMap<>();
        return minDistance(word1, word2, word1.length(), word2.length(), memo);
    }

    private int minDistance(String word1, String word2, int i, int j, Map<String, Integer> memo) {
        String key = i + "|" + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (i == 0) {
            return j;
        }
        if (j == 0) {
            return i;
        }
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return minDistance(word1, word2, i - 1, j - 1, memo);
        }
        // insert
        int a = minDistance(word1, word2, i, j - 1, memo);
        // delete
        int b = minDistance(word1, word2, i - 1, j, memo);
        // replace
        int c = minDistance(word1, word2, i - 1, j - 1, memo);
        int min = 1 + Math.min(a, Math.min(b, c));
        memo.put(key, min);
        return min;
    }
}
