package leetcode;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class Problem674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int tmpMax = 1;
        for (int prev = 0, current = 1; current < nums.length; current++, prev++) {
            if (nums[prev] < nums[current]) {
                tmpMax++;
            } else {
                max = Math.max(max, tmpMax);
                tmpMax = 1;
            }
        }
        max = Math.max(max, tmpMax);
        return max;
    }
}
