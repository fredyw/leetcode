package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 */
public class Problem1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int answer = 0;
        String sub = s.substring(0, minSize);
        Map<String, Integer> strCount = new HashMap<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : sub.toCharArray()) {
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        if (charCount.size() <= maxLetters) {
            int newCount;
            if (!strCount.containsKey(sub)) {
                newCount = 1;
                strCount.put(sub, newCount);
            } else {
                newCount = strCount.get(sub) + 1;
                strCount.put(sub, newCount);

            }
            answer = Math.max(answer, newCount);
        }
        for (int j = minSize; j < s.length(); j++) {
            int count = charCount.get(sub.charAt(0)) - 1;
            if (count == 0) {
                charCount.remove(sub.charAt(0));
            } else {
                charCount.put(sub.charAt(0), count);
            }
            char c = s.charAt(j);
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
            sub = sub.substring(1) + s.charAt(j);
            if (charCount.size() <= maxLetters) {
                int newCount;
                if (!strCount.containsKey(sub)) {
                    newCount = 1;
                    strCount.put(sub, 1);
                } else {
                    newCount = strCount.get(sub) + 1;
                    strCount.put(sub, newCount);
                }
                answer = Math.max(answer, newCount);
            }
        }
        return answer;
    }
}
