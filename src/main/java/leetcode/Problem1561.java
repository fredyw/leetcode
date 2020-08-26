package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
 */
public class Problem1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int answer = 0;
        for (int i = 0, j = piles.length - 2; i < j; i++, j -= 2) {
            answer += piles[j];
        }
        return answer;
    }
}
