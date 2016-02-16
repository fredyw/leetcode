package leetcode;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class Problem334 {
    public boolean increasingTriplet(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem334 prob = new Problem334();
        System.out.println(prob.increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(prob.increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
    }
}
