package leetcode;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class Problem659 {
    public boolean isPossible(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem659 prob = new Problem659();
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 4, 4, 5})); // false
    }
}
