package leetcode;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
 */
public class Problem1827 {
    public int minOperations(int[] nums) {
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                answer += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return answer;
    }
}
