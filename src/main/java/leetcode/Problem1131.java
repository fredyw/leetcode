package leetcode;

/**
 * https://leetcode.com/problems/maximum-of-absolute-value-expression/
 */
public class Problem1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1131 prob = new Problem1131();
        System.out.println(prob.maxAbsValExpr(new int[]{1, 2, 3, 4}, new int[]{-1, 4, 5, 6})); // 13
        System.out.println(prob.maxAbsValExpr(new int[]{1, -2, -5, 0, 10}, new int[]{0, -2, -1, -7, -4})); // 20
    }
}
