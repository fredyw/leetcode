package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] tmp = new int[nums.length];
        int num = nums[0];
        int count = 0;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            } else {
                count = 1;
                num = nums[i];
            }
            if (count < 3) {
                tmp[idx++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
        return idx;
    }
}
