package leetcode;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 */
public class Problem485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int tmpMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmpMax++;
            } else {
                tmpMax = 0;
            }
            max = Math.max(max, tmpMax);
        }
        return max;
    }
}
