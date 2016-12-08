package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();
        List<String> removedWords = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            for (; j + wordSize <= s.length(); j++) {
                String sub = s.substring(j, j + wordSize);
                if (!map.containsKey(sub)) {
                    break;
                } else {
                    int newCount = map.get(sub) - 1;
                    if (newCount == 0) {
                        map.remove(sub);
                    } else {
                        map.put(sub, newCount);
                    }
                    removedWords.add(sub);
                }
                j += wordSize - 1;
            }
            if (map.isEmpty()) {
                result.add(i);
                i = i + wordSize;
            } else {
                i++;
            }
            for (String word : removedWords) {
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
            removedWords.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        Problem30 prob = new Problem30();
        System.out.println(prob.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(prob.findSubstring("foobarthefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(prob.findSubstring("barbazthebarbarfoobaz", new String[]{"foo", "bar"})); // [12]
        System.out.println(prob.findSubstring("barbazbebarbarfoobaz", new String[]{"foo", "bar"})); // [11]
        System.out.println(prob.findSubstring("barbazthebarbarfoobaz", new String[]{"foo", "bar", "baz"})); // [12]
        System.out.println(prob.findSubstring("barbazthebarbarfoobaz", new String[]{"foo", "bar", "bar"})); // [9]
        System.out.println(prob.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})); // [6, 9, 12]
    }
}
