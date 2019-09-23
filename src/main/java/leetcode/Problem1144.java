package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/
 */
public class Problem1144 {
    public int movesToMakeZigzag(int[] nums) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        int min1 = numMoves(nums1, true);
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        int min2 = numMoves(nums2, false);
        return Integer.min(min1, min2);
    }

    private static int numMoves(int[] nums, boolean less) {
        int min = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (less) { // a < b
                if (nums[i] >= nums[i + 1]) {
                    min += nums[i] - nums[i + 1] + 1;
                    nums[i + 1] = nums[i] + 1;
                }
            } else { // a > b
                if (nums[i] <= nums[i + 1]) {
                    min += nums[i + 1] - nums[i] + 1;
                    nums[i + 1] = nums[i] + 1;
                }
            }
            less = !less;
        }
        return min;
    }

    public static void main(String[] args) {
        Problem1144 prob = new Problem1144();
//        System.out.println(prob.movesToMakeZigzag(new int[]{1,2,3})); // 2
//        System.out.println(prob.movesToMakeZigzag(new int[]{9,6,1,6,2})); // 4
        System.out.println(prob.movesToMakeZigzag(new int[]{7,4,8,9,7,7,5})); // 6
    }
}
