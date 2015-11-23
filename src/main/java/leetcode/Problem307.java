package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 */
public class Problem307 {
    public static class NumArray {
        private final int[] binaryIndexTree;
        private final int[] nums;

        public NumArray(int[] nums) {
            // https://en.wikipedia.org/wiki/Fenwick_tree
            this.nums = new int[nums.length];
            binaryIndexTree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                update(i, nums[i]);
            }
        }

        void update(int i, int val) {
            int delta = val - nums[i];
            nums[i] = val;
            int idx = i + 1;
            while (idx <= nums.length) {
                binaryIndexTree[idx] += delta;
                idx += idx & (-idx);
            }
        }

        private int sum(int i) {
            int sum = 0;
            int idx = i + 1;
            while (idx > 0) {
                sum += binaryIndexTree[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }

        public int sumRange(int i, int j) {
            return sum(j) - sum(i - 1);
        }
    }
}
