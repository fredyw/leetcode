package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class Problem303 {
    public static class NumArray {
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            if (nums.length > 0) {
                for (int i = 1; i < nums.length; i++) {
                    nums[i] = nums[i] + nums[i - 1];
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i - 1 >= 0) {
                return nums[j] - nums[i -1];
            }
            return nums[j];
        }
    }
}
