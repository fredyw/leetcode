package leetcode;

/**
 * https://leetcode.com/problems/delete-and-earn/
 */
public class Problem740 {
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]] += nums[i];
        }
        int[] dp = new int[sums.length + 3];
        for (int i = sums.length - 2; i >= 0; i--) {
            int a = dp[i + 2] + sums[i];
            int b = dp[i + 3] + sums[i + 1];
            dp[i] = Math.max(a, b);
        }
        return dp[0];
    }

//    public int deleteAndEarn(int[] nums) {
//        int[] sums = new int[10001];
//        for (int i = 0; i < nums.length; i++) {
//            sums[nums[i]] += nums[i];
//        }
//        Integer[] memo = new Integer[10001];
//        return deleteAndEarn(sums, 0, memo);
//    }
//
//    private static int deleteAndEarn(int[] sums, int idx, Integer[] memo) {
//        if (idx + 1 >= sums.length) {
//            return 0;
//        }
//        if (memo[idx] != null) {
//            return memo[idx];
//        }
//        int a = deleteAndEarn(sums, idx + 2, memo) + sums[idx];
//        int b = deleteAndEarn(sums, idx + 3, memo) + sums[idx + 1];
//        int max = Math.max(a, b);
//        memo[idx] = max;
//        return max;
//    }
}
