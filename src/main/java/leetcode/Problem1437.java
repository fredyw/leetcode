package leetcode;

/**
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */
public class Problem1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int prevIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prevIdx == -1 && nums[i] == 1) {
                prevIdx = i;
            } else if (nums[i] == 1) {
                if (Math.abs(i - prevIdx - 1) < k) {
                    return false;
                }
                prevIdx = i;
            }
        }
        return true;
    }
}
