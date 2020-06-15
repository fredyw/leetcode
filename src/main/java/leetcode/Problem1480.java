package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class Problem1480 {
    public int[] runningSum(int[] nums) {
        int[] answer = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            answer[i] = sum;
        }
        return answer;
    }
}
