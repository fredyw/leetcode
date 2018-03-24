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
            int lastIndex = 0;
            boolean found = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    found = false;
                    break;
                }
                List<Integer> indices = map.get(c);
                int index = Collections.binarySearch(indices, lastIndex);
                if (index < 0) {
                    index = (-(index) - 1);
                    if (index >= S.length()) {
                        found = false;
                        break;
                    }
                }
                lastIndex = index;
            }

            if (found) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem792 prob = new Problem792();
        System.out.println(prob.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"})); // 3
    }
}
