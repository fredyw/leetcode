package leetcode;

/**
 * https://leetcode.com/problems/longest-arithmetic-sequence/
 */
public class Problem1027 {
    public int longestArithSeqLength(int[] A) {
        Integer[][] memo = new Integer[A.length][A.length];
        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                answer = Math.max(answer, longestArithSeqLength(A, i, j, memo) + 2);
            }
        }
        return answer;
    }

    private static int longestArithSeqLength(int[] a, int i, int j, Integer[][] memo) {
        if (j == a.length) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int max = 0;
        for (int k = j + 1; k < a.length; k++) {
            int diff1 = a[j] - a[i];
            int diff2 = a[k] - a[j];
            if (diff1 == diff2) {
                max = Math.max(max, longestArithSeqLength(a, j, k, memo) + 1);
            }
        }
        memo[i][j] = max;
        return max;
    }

    public static void main(String[] args) {
        Problem1027 prob = new Problem1027();
        System.out.println(prob.longestArithSeqLength(new int[]{3, 6, 9, 12})); // 4
        System.out.println(prob.longestArithSeqLength(new int[]{9, 4, 7, 2, 10})); // 3
        System.out.println(prob.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8})); // 4
        System.out.println(prob.longestArithSeqLength(new int[]{24, 13, 1, 100, 0, 94, 3, 0, 3})); // 2
    }
}
