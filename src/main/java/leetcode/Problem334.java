package leetcode;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= max) {
                max = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem334 prob = new Problem334();
//        System.out.println(prob.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
//        System.out.println(prob.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
//        System.out.println(prob.increasingTriplet(new int[]{1, 9, 8, 7, 6, 15, 3, 2, 4})); // true
//        System.out.println(prob.increasingTriplet(new int[]{10, 9, 8, 7, 6, 15, 1, 3, 2, 4})); // true
//        System.out.println(prob.increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4})); // true
//        System.out.println(prob.increasingTriplet(new int[]{0, 4, 2, 1, 0, -1, -3})); // false
//        System.out.println(prob.increasingTriplet(new int[]{2, 1, 5, 0, 3})); // false
//        System.out.println(prob.increasingTriplet(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2})); // false;
//        System.out.println(prob.increasingTriplet(new int[]{1, 0, 0, 0, 10, 0, 1000})); // true
//        System.out.println(prob.increasingTriplet(new int[]{1, 8, 4, 0, 5})); // true
//        System.out.println(prob.increasingTriplet(new int[]{1, 4, 0, 1, 2})); // true
//        System.out.println(prob.increasingTriplet(new int[]{1, 4, 0, 8, 5})); // true
//        System.out.println(prob.increasingTriplet(new int[]{1, 2, -10, -8, -7})); // true
    }
}
