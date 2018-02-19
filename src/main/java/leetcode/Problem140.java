package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break-ii/
 */
public class Problem140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        return wordBreak(s, words, new HashMap<>());
    }

    private static List<String> wordBreak(String s, Set<String> words, Map<String, List<String>> memo) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (words.contains(s)) {
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(i);
            if (words.contains(sub)) {
                List<String> strings = wordBreak(s.substring(0, i), words, memo);
                for (int j = 0; j < strings.size(); j++) {
                    result.add(strings.get(j) + " " + sub);
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}
