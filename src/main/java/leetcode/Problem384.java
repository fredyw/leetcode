package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class Problem384 {
    public static class Solution {
        private final int[] nums;
        private final int[] original;
        private final Random random = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
            original = Arrays.copyOf(nums, nums.length);
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            // Knuth's shuffle
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(i + 1);
                swap(nums, i, j);
            }
            return nums;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
