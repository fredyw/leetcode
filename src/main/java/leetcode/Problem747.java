package leetcode;

/**
 * https://leetcode.com/problems/largest-number-greater-than-twice-of-others/
 */
public class Problem747 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int firstMax = -1;
        int firstMaxIdx = -1;
        int secondMax = -1;
        for (int i = 0; i < nums.length; i++) {
            if (firstMax < nums[i]) {
                secondMax = firstMax;
                firstMax = nums[i];
                firstMaxIdx = i;
            } else if (secondMax < nums[i]) {
                secondMax = nums[i];
            }
        }
        return firstMax >= secondMax * 2 ? firstMaxIdx : -1;
    }
}
