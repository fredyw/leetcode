package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/can-make-palindrome-from-substring/
 */
public class Problem1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> answer = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        int[] prefixCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            prefixCounts[s.charAt(i) - 'a']++;
            map.put(i, Arrays.copyOf(prefixCounts, prefixCounts.length));
        }
        for (int[] query : queries) {
            int[] fromCounts = map.getOrDefault(query[0] - 1, new int[26]);
            int[] counts = Arrays.copyOf(map.get(query[1]), 26);
            for (int i = 0; i < fromCounts.length; i++) {
                counts[i] -= fromCounts[i];
            }
            int count = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0 && counts[i] % 2 != 0) {
                    count++;
                }
            }
            if (query[2] == 0) {
                answer.add(count <= 1);
            } else {
                answer.add((count / 2) <= query[2]);
            }
        }
        return answer;
    }
}
