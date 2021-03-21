package leetcode;

/**
 * https://leetcode.com/problems/maximum-ascending-subarray-sum/
 */
public class Problem1800 {
    public int maxAscendingSum(int[] nums) {
        int answer = nums[0];
        int sum = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                sum += nums[i + 1];
            } else {
                sum = nums[i + 1];
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}
