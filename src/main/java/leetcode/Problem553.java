package leetcode;

/**
 * https://leetcode.com/problems/optimal-division/
 */
public class Problem553 {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return Integer.toString(nums[0]);
        } else if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        String result = Integer.toString(nums[0]) + "/(";
        for (int i = 2; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                result += nums[i] + "/";
            } else {
                result += nums[i];
            }
        }
        result += ")";
        return result;
    }
}
