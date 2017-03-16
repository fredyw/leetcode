package leetcode;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class Problem410 {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int) binary(nums, m, max, sum);
    }

    private static long binary(int[] nums, int m, long lo, long hi) {
        long mid = 0;
        while (lo < hi) {
            mid = (hi + lo) / 2;
            if (valid(nums, m, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }

    private static boolean valid(int[] nums, int m, long max) {
        int sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                sum = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
