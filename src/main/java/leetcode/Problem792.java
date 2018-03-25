package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */
public class Problem792 {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!map.containsKey(c)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            } else {
                map.get(c).add(i);
            }
        }

        for (String word : words) {
            int nextIndex = -1;
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    found = false;
                    break;
                }
                List<Integer> indices = map.get(c);
                if (nextIndex == -1) {
                    nextIndex = indices.get(0) + 1;
                    continue;
                }
                int index = Collections.binarySearch(indices, nextIndex);
                if (index < 0) {
                    int insertion = (-(index) - 1);
                    if (insertion >= indices.size()) {
                        found = false;
                        break;
                    }
                    nextIndex = indices.get(insertion) + 1;
                } else {
                    nextIndex = indices.get(index) + 1;
                }
            }

            if (found) {
                result++;
            }
        }
        return result;
    }
}
