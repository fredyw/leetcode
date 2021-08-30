package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class Problem1984 {
    public int minimumDifference(int[] nums, int k) {
        int answer = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i - k + 1 >= 0; i--) {
            if (i == nums.length - 1) {
                answer = nums[i] - nums[i - k + 1];
            } else {
                answer = Math.min(answer, nums[i] - nums[i - k + 1]);
            }
        }
        return answer;
    }
}
