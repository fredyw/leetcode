package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
 */
public class Problem1781 {
    public int beautySum(String s) {
        int[][] counts = new int[s.length()][26];
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                counts[i] = Arrays.copyOf(counts[i - 1], 26);
            }
            counts[i][s.charAt(i) - 'a']++;
        }
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int k = 0; k < counts[j].length; k++) {
                    int count = counts[j][k] - (i - 1 < 0 ? 0 : counts[i - 1][k]);
                    if (count == 0) {
                        continue;
                    }
                    min = Math.min(min, count);
                    max = Math.max(max, count);
                }
                answer += max - min;
            }
        }
        return answer;
    }
}
