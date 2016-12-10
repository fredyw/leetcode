package leetcode;

/**
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Problem41 {
    public int firstMissingPositive(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem41 prob = new Problem41();
        System.out.println(prob.firstMissingPositive(new int[]{1, 2, 0})); // 3
        System.out.println(prob.firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
        System.out.println(prob.firstMissingPositive(new int[]{1, 2, 6, 5})); // 3
    }
}
