package leetcode;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        int n = 3;
        if (nums.length < n) {
            return false;
        }
        int count = 0;
        int prev = nums[0];
        int lower = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
//            System.out.println("i=" + i + ", val=" + nums[i]);
//            System.out.println(" - " + prev + " < " + nums[i]);
            if (prev < nums[i]) {
                lower = prev;
                count++;
//                System.out.println(" - increment counter: " + count);
//                System.out.println(" - prev: " + prev);
            } else if (prev > nums[i]) {
                if (lower >= nums[i]) {
                    count--;
                }
            }
//            System.out.println(" - setting prev to: " + nums[i]);
            prev = nums[i];
            if (count == n - 1) {
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
        System.out.println(prob.increasingTriplet(new int[]{1, 0, 0, 0, 10, 0, 1000})); // true
    }
}
