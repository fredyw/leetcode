package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/richest-customer-wealth/
 */
public class Problem1672 {
    public int maximumWealth(int[][] accounts) {
        int answer = 0;
        for (int[] account : accounts) {
            answer = Math.max(answer, Arrays.stream(account).sum());
        }
        return answer;
    }
}
