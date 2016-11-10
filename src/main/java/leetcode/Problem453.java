package leetcode;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 */
public class Problem453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] - min;
        }
        return result;
    }
}
