package leetcode;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int x = 1;
        // forward
        for (int i = 0; i < nums.length; i++) {
            x *= nums[i];
            output[i] = x;
        }
        x = 1;
        int backward = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i != 0) {
                x = output[i - 1] * backward;
                backward *= nums[i];
            } else {
                x = backward;
            }
            output[i] = x;
        }
        return output;
    }
}
