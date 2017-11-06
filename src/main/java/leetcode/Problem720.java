package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary/
 */
public class Problem720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }
        String result = "";
        for (String word : words) {
            boolean found = true;
            String tmp = "";
            for (int i = 0; i < word.length(); i++) {
                tmp += word.charAt(i);
                if (!set.contains(tmp)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                if (word.length() > result.length()) {
                    result = word;
                } else if (word.length() == result.length()) {
                    if (word.compareTo(result) < 0) {
                        result = word;
                    }
                }
            }
        }
        return result;
    }
}
