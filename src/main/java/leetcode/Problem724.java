package leetcode;

/**
 * https://leetcode.com/problems/find-pivot-index/description/
 */
public class Problem724 {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            sums[i] = totalSum;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            if (i > 0) {
                left = sums[i - 1];
            }
            if (totalSum - sums[i] == left) {
                return i;
            }
        }
        return -1;
    }
}
