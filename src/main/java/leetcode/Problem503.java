package leetcode;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class Problem503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                result[i] = -1;
                continue;
            }
            int j = i + 1;
            if (j == nums.length) {
                j = 0;
            }
            while (nums[i] >= nums[j]) {
                j++;
                if (j == nums.length) {
                    j = 0;
                }
            }
            result[i] = nums[j];
        }
        return result;
    }
}
