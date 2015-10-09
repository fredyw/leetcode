package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/next-permutation/
 */
public class Problem31 {
    public void nextPermutation(int[] nums) {
        for (int current = nums.length-2; current >= 0; current--) {
            if (nums[current] < nums[current+1]) {
                int val = nums[current];
                Arrays.sort(nums, current, nums.length);
                int idx = Arrays.binarySearch(nums, current, nums.length, val);
                while (idx+1 < nums.length && nums[idx+1] == val) {
                    idx++;
                }
                int tmp = nums[idx+1];
                for (int i = idx+1; i >= current+1; i--) {
                    nums[i] = nums[i-1];
                }
                nums[current] = tmp;
                return;
            }
        }
        Arrays.sort(nums);
    }
}
