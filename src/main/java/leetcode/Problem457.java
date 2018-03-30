package leetcode;

/**
 * https://leetcode.com/problems/circular-array-loop/
 */
public class Problem457 {
    public boolean circularArrayLoop(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem457 prob = new Problem457();
        System.out.println(prob.circularArrayLoop(new int[]{2, -1, 1, 2, 2})); // true
        System.out.println(prob.circularArrayLoop(new int[]{2, -1, 1, 1, 2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, 2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, 1})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, -2})); // false
        System.out.println(prob.circularArrayLoop(new int[]{-1, -1, -2})); // true
        System.out.println(prob.circularArrayLoop(new int[]{1, -1})); // false
    }
}
