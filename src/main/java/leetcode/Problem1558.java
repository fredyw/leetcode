package leetcode;

/**
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 */
public class Problem1558 {
    public int minOperations(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1558 prob = new Problem1558();
        System.out.println(prob.minOperations(new int[]{1,5})); // 5
        System.out.println(prob.minOperations(new int[]{2,2})); // 3
        System.out.println(prob.minOperations(new int[]{4,2,5})); // 6
        System.out.println(prob.minOperations(new int[]{3,2,2,4})); // 7
        System.out.println(prob.minOperations(new int[]{2,4,8,16})); // 8
        System.out.println(prob.minOperations(new int[]{2,3,10})); // 8
    }
}
