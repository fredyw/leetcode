package leetcode;

/**
 * https://leetcode.com/problems/missing-number/
 */
public class Problem268 {
    public int missingNumber(int[] nums) {
        int expected = 0;
        for (int i = 0; i <= nums.length; i++) {
            expected += i;
        }
        int actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return expected - actual;
    }
}