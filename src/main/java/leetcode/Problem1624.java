package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */
public class Problem1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] indexes = new int[26];
        Arrays.fill(indexes, -1);
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = indexes[s.charAt(i) - 'a'];
            if (index == -1) {
                indexes[s.charAt(i) - 'a'] = i;
            }
        }
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            int index = indexes[s.charAt(i) - 'a'];
            if (index > i) {
                answer = Math.max(answer, index - i - 1);
            }
        }
        return answer;
    }
}
