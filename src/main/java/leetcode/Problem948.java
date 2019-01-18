package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/bag-of-tokens/
 */
public class Problem948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int power = P;
        int points = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            while (left < tokens.length && power - tokens[left] >= 0) {
                power -= tokens[left];
                points++;
                left++;
            }
            if (left >= right || points == 0) {
                break;
            } else {
                power += tokens[right];
                points--;
                right--;
            }
        }
        return points;
    }
}
