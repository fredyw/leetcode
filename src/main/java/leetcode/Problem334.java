package leetcode;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= max) {
                max = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
