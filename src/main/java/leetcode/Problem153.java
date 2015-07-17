package leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Problem153 {
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int n : nums) {
            if (n < min) {
                min = Math.min(n, min);
            }
        }
        return min;
    }
}
