package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 */
public class Problem1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int answer = 0;
        for (int i = minSize; i < maxSize; i++) {
            String sub = s.substring(0, i);
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : sub.toCharArray()) {
                int count = charCount.getOrDefault(c, 0);
                if (count == 0 && charCount.size() + 1 > maxLetters) {
                    // TODO
                }
                if (!charCount.containsKey(c)) {
                    charCount.put(c, 1);
                } else {
                    charCount.put(c, charCount.get(c) + 1);
                }
            }
            Map<String, Integer> strCount = new HashMap<>();
            strCount.put(sub, 1);
            for (int j = minSize + 1; j < s.length(); j++) {
                char c = s.charAt(j);
                int count = charCount.getOrDefault(c, 0);
                if (count == 0 && charCount.size() + 1 > maxLetters) {
                    // TODO
                }
                if (!charCount.containsKey(c)) {
                    charCount.put(c, 1);
                } else {
                    charCount.put(c, charCount.get(c) + 1);
                }
                sub = sub.substring(1) + s.charAt(j);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1297 prob = new Problem1297();
        System.out.println(prob.maxFreq("aababcaab", 2, 3, 4)); // 2
//        System.out.println(prob.maxFreq("aababcaab", 1, 1, 4)); // 5
//        System.out.println(prob.maxFreq("aababcaab", 2, 2, 4)); // 3
//        System.out.println(prob.maxFreq("aababcaabaa", 2, 2, 4)); // 3
//        System.out.println(prob.maxFreq("aaaa", 1, 3, 3)); // 2
//        System.out.println(prob.maxFreq("aabcabcab", 2, 2, 3)); // 3
//        System.out.println(prob.maxFreq("abcde", 2, 3, 3)); // 0
    }
}
