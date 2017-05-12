package leetcode;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class Problem560 {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] < k) {
                sum += nums[i];
            } else if (sum + nums[i] == k) {
                if (nums[i] != k) {
                    sum = nums[i];
                }
                result++;
            } else if (nums[i] == k) {
                result++;
                sum = 0;
            } else {
                sum = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem560 prob = new Problem560();
        System.out.println(prob.subarraySum(new int[]{1, 1, 1}, 2)); // 2
        System.out.println(prob.subarraySum(new int[]{1, 1, 1, 2, 1, 1, 1}, 2)); // 5
        System.out.println(prob.subarraySum(new int[]{-1, -1, 1}, 0)); // 1
        System.out.println(prob.subarraySum(new int[]{-1, -1, 1, -1, -1}, 0)); // 2
        System.out.println(prob.subarraySum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0)); // 55
    }
}
