package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-string-chain/
 */
public class Problem1048 {
    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word.length())) {
                map.put(word.length(), new ArrayList<>());
            }
            map.get(word.length()).add(word);
        }
        int answer = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (String word : words) {
            answer = Math.max(answer, longestStrChain(map, word, memo) + 1);
        }
        return answer;
    }

    private static int longestStrChain(Map<Integer, List<String>> words, String word,
                                       Map<String, Integer> memo) {
        if (!words.containsKey(word.length() + 1)) {
            return 0;
        }
        if (memo.containsKey(word)) {
            return memo.get(word);
        }
        int max = 0;
        for (String s : words.get(word.length() + 1)) {
            if (isValid(word, s)) {
                max = Math.max(max, longestStrChain(words, s, memo) + 1);
            }
        }
        memo.put(word, max);
        return max;
    }

    private static boolean isValid(String word1, String word2) {
        int[] counts1 = new int[26];
        for (char c : word1.toCharArray()) {
            counts1[c - 'a']++;
        }
        int[] counts2 = new int[26];
        for (char c : word2.toCharArray()) {
            counts2[c - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < counts1.length; i++) {
            diff += Math.abs(counts2[i] - counts1[i]);
        }
        return diff == 1;
    }
}
