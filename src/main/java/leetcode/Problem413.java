package leetcode;

/**
 * https://leetcode.com/problems/arithmetic-slices/
 */
public class Problem413 {
    public int numberOfArithmeticSlices(int[] A) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem413 prob = new Problem413();
        System.out.println(prob.numberOfArithmeticSlices(new int[]{1, 1, 2, 5, 7})); // 0
        System.out.println(prob.numberOfArithmeticSlices(new int[]{1, 1, 1, 2, 5, 7})); // 1
        System.out.println(prob.numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(prob.numberOfArithmeticSlices(new int[]{1, 3, 5, 7, 9})); // 6
        System.out.println(prob.numberOfArithmeticSlices(new int[]{7, 7, 7, 7})); // 3
        System.out.println(prob.numberOfArithmeticSlices(new int[]{3, -1, -5, -9})); // 3
        System.out.println(prob.numberOfArithmeticSlices(new int[]{1, 1, 1, 2, 5, 8})); // 2

    }
}
