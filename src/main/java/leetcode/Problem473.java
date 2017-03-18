package leetcode;

/**
 * https://leetcode.com/problems/matchsticks-to-square/
 */
public class Problem473 {
    public boolean makesquare(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem473 prob = new Problem473();
        System.out.println(prob.makesquare(new int[]{1, 1, 2, 2, 2})); // true
        System.out.println(prob.makesquare(new int[]{3, 3, 3, 3, 4})); // false
        System.out.println(prob.makesquare(new int[]{1, 1, 1, 1, 1, 1, 1, 1})); // true
    }
}
