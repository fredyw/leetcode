package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class Problem1509 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 2; i < 3; i++, j++) {
            answer = Math.min(answer, nums[j - 1] - nums[i + 1]);
        }
        for (int i = 1, j = nums.length - 1; j > nums.length - 4; j--, i--) {
            answer = Math.min(answer, nums[j - 1] - nums[i + 1]);
        }
        return answer;
    }
}
