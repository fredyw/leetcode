package leetcode;

/**
 * https://leetcode.com/problems/third-maximum-number/
 */
public class Problem414 {
    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (int i = 0; i < nums.length; i++) {
            if (max1 == null) {
                max1 = nums[i];
                continue;
            }
            if (max1 == nums[i]) {
                continue;
            }
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
                continue;
            }
            if (max2 == null) {
                max2 = nums[i];
                continue;
            }
            if (max2 == nums[i]) {
                continue;
            }
            if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
                continue;
            }
            if (max3 == null) {
                max3 = nums[i];
            }
            if (max3 == nums[i]) {
                continue;
            }
            if (max3 < nums[i]) {
                max3 = nums[i];
                continue;
            }
        }
        return (max3 == null) ? max1 : max3;
    }
}
