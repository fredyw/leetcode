package leetcode;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class Problem416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][(sum / 2) + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j <= (sum / 2); j++) {
                if (j == sum - j) {
                    dp[i][j] = true;
                } else if (j + nums[i] <= (sum / 2)) {
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + nums[i]];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];

        // int sum = 0;
        // for (int num : nums) {
        //     sum += num;
        // }
        // if (sum % 2 != 0) {
        //     return false;
        // }
        // return canPartition(nums, sum / 2, 0, new Boolean[nums.length][(sum / 2) + 1]);
    }

    private static boolean canPartition(int[] nums, int sum, int index, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index == nums.length) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }
        boolean found = canPartition(nums, sum, index + 1, memo) ||
            canPartition(nums, sum - nums[index], index + 1, memo);
        memo[index][sum] = found;
        return found;
    }
}
