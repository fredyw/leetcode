package leetcode;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class Problem473 {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int length = sum / 4;
        int remainder = sum % 4;
        if (remainder != 0) {
            return false;
        }

        return true;
    }

    private static boolean makeSquare(int[] nums, int length) {
        if (length < 0) {
            return false;
        }
        if (length == 0) {
            return true;
        }
        boolean valid = false;
        for (int i = 0; i < nums.length; i++) {
            valid |= makeSquare(nums, length - nums[i]);
        }
        return valid;
    }

    public static void main(String[] args) {
        Problem473 prob = new Problem473();
        System.out.println(prob.makesquare(new int[]{1, 1, 2, 2, 2})); // true
        System.out.println(prob.makesquare(new int[]{3, 3, 3, 3, 4})); // false
        System.out.println(prob.makesquare(new int[]{3, 3, 3, 3, 3})); // false
        System.out.println(prob.makesquare(new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // true
        System.out.println(prob.makesquare(new int[]{3, 5, 4, 4, 6, 2, 1, 1, 1, 5})); // true
    }
}
