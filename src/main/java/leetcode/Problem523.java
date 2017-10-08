package leetcode;

/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class Problem523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Boolean[][] memo = new Boolean[nums.length + 1][nums.length + 1];
        return checkSubarraySum(nums, k, 0, nums.length, memo);
    }

    private static boolean checkSubarraySum(int[] nums, int k, int i, int j, Boolean[][] memo) {
        if (i >= j) {
            return false;
        }
        if (j - i == 1) {
            return false;
        }
        int sum = 0;
        for (int x = i; x < j; x++) {
            sum += nums[x];
        }
        if (sum == 0 && k == 0) {
            return true;
        }
        if (k == 0) {
            return false;
        }
        if (sum % k == 0) {
            return true;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean a = checkSubarraySum(nums, k, i + 1, j, memo);
        boolean b = checkSubarraySum(nums, k, i, j - 1, memo);
        boolean c = checkSubarraySum(nums, k, i + 1, j - 1, memo);
        boolean result = a | b | c;
        memo[i][j] = result;
        return result;
    }

    public static void main(String[] args) {
        Problem523 prob = new Problem523();
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 8}, 6)); // true
        System.out.println(prob.checkSubarraySum(new int[]{1, 2, 3}, 4)); // false
        System.out.println(prob.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 0)); // false
        System.out.println(prob.checkSubarraySum(new int[]{0, 0}, 0)); // true
        System.out.println(prob.checkSubarraySum(new int[]{0}, 0)); // false
    }
}
