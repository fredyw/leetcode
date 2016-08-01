package leetcode;

/**
 * https://leetcode.com/problems/jump-game/
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int x = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (x <= 0) {
                return false;
            }
            x = Math.max(x - 1, nums[i]);
        }
        return true;
    }
}
