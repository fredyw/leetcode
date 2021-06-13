package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/
 */
public class Problem1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            answer = Math.max(answer, nums[i] + nums[j]);
        }
        return answer;
    }
}
