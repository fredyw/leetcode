package leetcode;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class Problem1413 {
    public int minStartValue(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1413 prob = new Problem1413();
        System.out.println(prob.minStartValue(new int[]{-3,2,-3,4,2})); // 5
        System.out.println(prob.minStartValue(new int[]{1,2})); // 1
        System.out.println(prob.minStartValue(new int[]{1,-2,-3})); // 5
    }
}
