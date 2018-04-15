package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-common-word/
 */
public class Problem819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String b :banned) {
            bannedWords.add(b);
        }
        String[] words = paragraph.split("\\s+|!|\\?|'|,|;|\\.");
        Map<String, Integer> map = new HashMap<>();
        String maxWord = "";
        int max = 0;
        for (String word : words) {
            word = word.toLowerCase();
            if (word.isEmpty() || bannedWords.contains(word)) {
                continue;
            }
            int newMax = 0;
            if (!map.containsKey(word)) {
                newMax = 1;
                map.put(word, newMax);
            } else {
                newMax = map.get(word) + 1;
                map.put(word, newMax);
            }
            if (max < newMax) {
                max = newMax;
                maxWord = word;
            }
        }
        return maxWord;
    }
}
