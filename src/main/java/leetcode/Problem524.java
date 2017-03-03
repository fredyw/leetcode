package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class Problem524 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        Collections.sort(d);
        for (String word : d) {
            int i = 0;
            int j = 0;
            int count = 0;
            for (; i < s.length() && j < word.length(); i++, j++) {
                char c1 = word.charAt(j);
                while (i < s.length()) {
                    char c2 = s.charAt(i);
                    if (c1 == c2) {
                        count++;
                        break;
                    }
                    i++;
                }
            }
            if (count == word.length()) {
                if (longest.length() < word.length()) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}
