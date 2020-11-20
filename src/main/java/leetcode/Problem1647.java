package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
public class Problem1647 {
    public int minDeletions(String s) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        Arrays.sort(counts);
        int answer = 0;
        for (int i = counts.length - 1; i > 0; i--) {
            if (counts[i] == 0) {
                int delete = counts[i - 1] - counts[i];
                answer += delete;
                counts[i - 1] -= delete;
            } else if (counts[i] <= counts[i - 1]) {
                int delete = counts[i - 1] - counts[i] + 1;
                answer += delete;
                counts[i - 1] -= delete;
            }
        }
        return answer;
    }
}
