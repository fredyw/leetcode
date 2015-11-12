package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class Problem303 {
    public static class NumArray {
        private final Map<Integer, Integer> map = new HashMap<>();
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            if (nums.length > 0) {
                int sum = nums[0];
                for (int i = 1; i < nums.length; i++) {
                    sum += nums[i];
                    map.put(i, sum);
                }
            }
        }

        public int sumRange(int i, int j) {
            if (i == j) {
                return nums[i];
            }
            Integer a = map.get(i);
            if (a == null) {
                a = 0;
            }
            if (i > 0) {
                a -= nums[i];
            }
            Integer b = map.get(j);
            if (b == null) {
                b = 0;
            }
            return b - a;
        }
    }
}
