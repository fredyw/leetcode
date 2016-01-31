package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Problem324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            mid--;
        }
        int j = mid;
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = newNums[mid--];
        }
        j = newNums.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = newNums[j--];
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i < nums.length && j < nums.length) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
