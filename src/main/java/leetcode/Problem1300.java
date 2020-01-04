package leetcode;

/**
 * https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/
 */
public class Problem1300 {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int max = 0;
        for (int num : arr) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum <= target) {
            return max;
        }
        int left = 1;
        int right = max;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            sum = 0;
            for (int num : arr) {
                sum += (num > mid) ? mid : num;
            }
            if (sum >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int num : arr) {
            sum1 += (num > left) ? (left) : num;
            sum2 += (num > left - 1) ? (left - 1) : num;
        }
        return (Math.abs(sum2 - target) <= Math.abs(sum1 - target)) ? left - 1 : left;
    }
}
