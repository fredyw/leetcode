package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-gap/
 */
public class Problem164 {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            answer = Math.max(answer, diff);
        }
        return answer;
    }
}
