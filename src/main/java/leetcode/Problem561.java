package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/array-partition-i
 */
public class Problem561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += Math.min(nums[i], nums[i + 1]);
            i += 2;
        }
        return sum;
    }
}
