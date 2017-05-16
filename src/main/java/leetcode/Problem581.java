package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class Problem581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < nums.length && nums[i++] == sorted[j++]) {
            count++;
        }
        if (nums.length == count) {
            return 0;
        }
        i = nums.length - 1;
        j = nums.length - 1;
        while (i >= 0 && nums[i--] == sorted[j--]) {
            count++;
        }
        return nums.length - count;
    }
}
