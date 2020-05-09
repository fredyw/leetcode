package leetcode;

/**
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
 */
public class Problem1437 {
    public boolean kLengthApart(int[] nums, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1437 prob = new Problem1437();
        System.out.println(prob.kLengthApart(new int[]{1,0,0,0,1,0,0,1}, 2)); // true
        System.out.println(prob.kLengthApart(new int[]{1,0,0,1,0,1}, 2)); // false
        System.out.println(prob.kLengthApart(new int[]{1,1,1,1,1}, 0)); // true
        System.out.println(prob.kLengthApart(new int[]{0,1,0,1}, 1)); // true
    }
}
