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
        Map<Integer, List<WordCount>> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word.length())) {
                map.put(word.length(), new ArrayList<>());
            }
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            map.get(word.length()).add(new WordCount(word, count));
        }
        int answer = 0;
        Map<String, Integer> memo = new HashMap<>();
        for (List<WordCount> wordCounts : map.values()) {
            for (WordCount wordCount : wordCounts) {
                answer = Math.max(answer, longestStrChain(map, wordCount, memo) + 1);
            }
        }
        return answer;
    }

    private static class WordCount {
        private final String word;
        private final int[] count;

        public WordCount(String word, int[] count) {
            this.word = word;
            this.count = count;
        }
    }

    private static int longestStrChain(Map<Integer, List<WordCount>> words,
                                       WordCount wordCount, Map<String, Integer> memo) {
        if (!words.containsKey(wordCount.word.length() + 1)) {
            return 0;
        }
        if (memo.containsKey(wordCount.word)) {
            return memo.get(wordCount.word);
        }
        int max = 0;
        for (WordCount next : words.get(wordCount.word.length() + 1)) {
            if (isValid(wordCount.count, next.count)) {
                max = Math.max(max, longestStrChain(words, next, memo) + 1);
            }
        }
        memo.put(wordCount.word, max);
        return max;
    }

    private static boolean isValid(int[] count1, int[] count2) {
        int diff = 0;
        for (int i = 0; i < count1.length; i++) {
            diff += Math.abs(count2[i] - count1[i]);
        }
        return diff == 1;
    }
}
