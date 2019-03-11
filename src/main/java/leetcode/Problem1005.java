package leetcode;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/
 */
public class Problem1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1005 prob = new Problem1005();
        System.out.println(prob.largestSumAfterKNegations(new int[]{4, 2, 3}, 1)); // 5
        System.out.println(prob.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3)); // 6
        System.out.println(prob.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2)); // 13
    }
}
