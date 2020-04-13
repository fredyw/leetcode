package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/string-matching-in-an-array/
 */
public class Problem1408 {
    public List<String> stringMatching(String[] words) {
        Set<String> answer = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    answer.add(words[i]);
                }
                if (words[i].contains(words[j])) {
                    answer.add(words[j]);
                }
            }
        }
        return new ArrayList<>(answer);
    }
}
