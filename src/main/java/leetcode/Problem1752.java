package leetcode;

/**
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 */
public class Problem1752 {
    public boolean check(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1752 prob = new Problem1752();
        System.out.println(prob.check(new int[]{3,4,5,1,2})); // true
        System.out.println(prob.check(new int[]{2,1,3,4})); // false
        System.out.println(prob.check(new int[]{1,2,3})); // true
        System.out.println(prob.check(new int[]{1,1,1})); // true
        System.out.println(prob.check(new int[]{2,1})); // true
    }
}
