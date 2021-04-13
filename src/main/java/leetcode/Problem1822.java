package leetcode;

/**
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */
public class Problem1822 {
    public int arraySign(int[] nums) {
        int answer;
        if (nums[0] < 0) {
            answer = -1;
        } else if (nums[0] == 0) {
            return 0;
        } else {
            answer = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                answer *= -1;
            } else if (nums[i] == 0) {
                return 0;
            }
        }
        return answer;
    }
}
