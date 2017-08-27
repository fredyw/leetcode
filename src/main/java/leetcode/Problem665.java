package leetcode;

/**
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int prev = 0;
        int count = 0;
        for (int curr = 1; curr < nums.length; curr++) {
            if (nums[prev] > nums[curr]) {
                if (prev == 0) {
                    nums[prev] = Integer.MIN_VALUE;
                } else {
                    if (nums[prev] == nums[prev - 1]) {
                        nums[curr] = nums[prev];
                    } else {
                        nums[prev] = nums[prev - 1];
                    }
                    if (nums[prev] > nums[curr]) {
                        return false;
                    }
                }
                count++;
                if (count == 2) {
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem665 prob = new Problem665();
        System.out.println(prob.checkPossibility(new int[]{4, 2, 3})); // true
        System.out.println(prob.checkPossibility(new int[]{4, 2, 1})); // false
        System.out.println(prob.checkPossibility(new int[]{1, 5, 2, 4})); // true
        System.out.println(prob.checkPossibility(new int[]{1})); // true
        System.out.println(prob.checkPossibility(new int[]{3, 4, 2, 3})); // false
        System.out.println(prob.checkPossibility(new int[]{-1, 4, 2, 3})); // true
        System.out.println(prob.checkPossibility(new int[]{2, 3, 3, 2, 4})); // true
        System.out.println(prob.checkPossibility(new int[]{1, 2, 4, 5, 3})); // true
    }
}
