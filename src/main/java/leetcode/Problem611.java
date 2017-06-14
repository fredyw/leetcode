package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number/
 */
public class Problem611 {
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                for (; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
