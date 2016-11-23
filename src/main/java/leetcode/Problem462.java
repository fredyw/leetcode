package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class Problem462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int mid = nums.length / 2;
        for (int i = 0; i < mid; i++) {
            result += nums[mid] - nums[i];
        }
        for (int i = mid + 1; i < nums.length; i++) {
            result += nums[i] - nums[mid];
        }
        return result;
    }
}
