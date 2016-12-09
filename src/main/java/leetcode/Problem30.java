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
        List<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();
        int totalSize = wordSize * words.length;
        if (totalSize > s.length()) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        int i = 0;
        while (i + totalSize <= s.length()) {
            int j = i;
            Map<String, Integer> copy = new HashMap<>(map);
            for (; j + wordSize <= s.length(); j++) {
                String sub = s.substring(j, j + wordSize);
                if (!copy.containsKey(sub)) {
                    break;
                } else {
                    int newCount = copy.get(sub) - 1;
                    if (newCount == 0) {
                        copy.remove(sub);
                    } else {
                        copy.put(sub, newCount);
                    }
                }
                j += wordSize - 1;
            }
            if (copy.isEmpty()) {
                result.add(i);
            }
            i++;
        }
        return result;
    }
}
