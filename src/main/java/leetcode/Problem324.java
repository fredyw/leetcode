package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
public class Problem324 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        boolean lessThan = true;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (lessThan) {
                if (nums[i] < nums[j]) {
                    i++;
                    swap(nums, i, j);
                    j = i + 1;
                    lessThan = false;
                } else {
                    j++;
                }
            } else {
                if (nums[i] > nums[j]) {
                    i++;
                    swap(nums, i, j);
                    j = i + 1;
                    lessThan = true;
                } else {
                    j++;
                }
            }
        }
        if (lessThan) {
            if (nums[i] > nums[j - 1]) {
                swap(nums, i, j - 1);
            }
        } else {
            if (nums[i] < nums[j - 1]) {
                swap(nums, i, j - 1);
            }
        }
        System.out.println("less than: " + lessThan);
        System.out.println(nums[i] + " -- " + nums[j-1]);
        // TODO:
    }

    private void swap(int[] nums, int i, int j) {
        if (i < nums.length && j < nums.length) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Problem324 prob = new Problem324();

        int[] nums = new int[]{1, 5, 1, 1, 6, 4};
        prob.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [1, 4, 1, 5, 1, 6]

        nums = new int[]{1, 3, 2, 2, 3, 1};
        prob.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // [2, 3, 1, 3, 1, 2]
    }
}
