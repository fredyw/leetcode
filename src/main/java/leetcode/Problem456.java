package leetcode;

/**
 * https://leetcode.com/problems/132-pattern/
 */
public class Problem456 {
    public boolean find132pattern(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem456 prob = new Problem456();
        System.out.println(prob.find132pattern(new int[]{1, 2, 3, 4})); // false
        System.out.println(prob.find132pattern(new int[]{3, 1, 4, 2})); // true
        System.out.println(prob.find132pattern(new int[]{-1, 3, 2, 0})); // true
    }
}
