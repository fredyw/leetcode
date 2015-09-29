package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class Problem283 {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
