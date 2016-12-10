package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 1 && nums[i] < nums.length) {
                swap(nums, nums[nums[i]] - 1, nums[i]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums.length) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Problem41 prob = new Problem41();
//        System.out.println(prob.firstMissingPositive(new int[]{1, 2, 0})); // 3
//        System.out.println(prob.firstMissingPositive(new int[]{})); // 1
//        System.out.println(prob.firstMissingPositive(new int[]{0})); // 1
//        System.out.println(prob.firstMissingPositive(new int[]{2})); // 1
//        System.out.println(prob.firstMissingPositive(new int[]{1})); // 2
//        System.out.println(prob.firstMissingPositive(new int[]{1, 1})); // 2
//        System.out.println(prob.firstMissingPositive(new int[]{2, 2, 4})); // 1
        System.out.println(prob.firstMissingPositive(new int[]{0, 2, 2, 1, 1})); // 3
    }
}
