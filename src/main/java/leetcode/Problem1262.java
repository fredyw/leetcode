package leetcode;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 */
public class Problem1262 {
    public int maxSumDivThree(int[] nums) {
        return maxSumDivThree(nums, 0, 0, new Integer[40001][3]);
    }

    private static int maxSumDivThree(int[] nums, int index, int sum, Integer[][] memo) {
        if (index == nums.length) {
            return 0;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        int max = 0;
        int val = maxSumDivThree(nums, index + 1, sum, memo);
        if ((sum + val) % 3 == 0) {
            max = val;
        }
        val = nums[index] + maxSumDivThree(nums, index + 1, (sum + nums[index]) % 3, memo);
        if ((sum + val) % 3 == 0) {
            max = Math.max(max, val);
        }
        memo[index][sum] = max;
        return max;
    }
}
