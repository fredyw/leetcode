package leetcode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class Problem45 {
    public int jump(int[] nums) {
        int result = 0;
        int i = 0;
        while (i < nums.length - 1) {
            int idx = 0;
            int nextIdx = 0;
            if (i + nums[i] >= nums.length - 1) {
                result++;
                break;
            }
            for (int j = i; j <= i + nums[i] && j < nums.length; j++) {
                if (j + nums[j] > nextIdx) {
                    idx = j;
                    nextIdx = j + nums[j];
                }
            }
            result++;
            if (idx == i) {
                i = i + nums[i];
            } else {
                i = idx;
            }
        }
        return result;
    }
}
