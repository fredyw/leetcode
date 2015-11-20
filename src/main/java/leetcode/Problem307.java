package leetcode;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 */
public class Problem307 {
    public static class NumArray {

        public NumArray(int[] nums) {

        }

        void update(int i, int val) {

        }

        public int sumRange(int i, int j) {
            // TODO:
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        NumArray numArray = new NumArray(nums);
        numArray.sumRange(0, 1);
        numArray.update(1, 10);
        numArray.sumRange(1, 2);
    }
}
