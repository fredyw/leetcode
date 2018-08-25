package leetcode;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
 */
public class Problem873 {
    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        Integer[][] memo = new Integer[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int val = lenLongestFibSubseq(A, i, j, memo);
                if (val > 0) {
                    val += 2;
                }
                max = Math.max(max, val);
            }
        }
        return max;
    }

    private int lenLongestFibSubseq(int[] a, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int sum = a[i] + a[j];
        int x = j + 1;
        while (x < a.length && a[x] <= sum) {
            if (a[x] == sum) {
                int val = lenLongestFibSubseq(a, j, x, memo) + 1;
                memo[i][j] = val;
                return val;
            }
            x++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem873 prob = new Problem873();
        System.out.println(prob.lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // 5
        System.out.println(prob.lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})); // 3
        System.out.println(prob.lenLongestFibSubseq(new int[]{1, 3, 5})); // 0
    }
}
