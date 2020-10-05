package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class Problem1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            int index = Arrays.binarySearch(nums, i);
            if (index < 0) {
                index = -(index) - 1;
            } else {
                while (index >= 0 && nums[index] == i) {
                    index--;
                }
                index++;
            }
            if (nums.length - index == i) {
                return i;
            }
        }
        return -1;
    }
}
