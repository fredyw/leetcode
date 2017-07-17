package leetcode;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 */
public class Problem643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                sum -= nums[i - k];
                count--;
            }
            sum += nums[i];
            count++;
            if (count == k) {
                max = Double.max(max, sum / k);
            }
        }
        return max;
    }
}
