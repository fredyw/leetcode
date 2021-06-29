package leetcode;

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */
public class Problem1909 {
    public boolean canBeIncreasing(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                if (i == 0 || i + 1 == nums.length - 1) {
                    count++;
                } else if (i - 1 >= 0 && nums[i - 1] < nums[i + 1]) {
                    count++;
                } else if (i + 2 < nums.length && nums[i] < nums[i + 2]) {
                    count++;
                } else {
                    return false;
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
