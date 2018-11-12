package leetcode;

/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */
public class Problem926 {
    public int minFlipsMonoIncr(String S) {
        int[] sum = new int[S.length() + 1];
        for (int i = 0; i < S.length(); ++i) {
            sum[i + 1] = sum[i] + (S.charAt(i) == '1' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= S.length(); ++i) {
            // Number of ones to flip.
            int left = sum[i];
            // Number of zeros to flip.
            int right = S.length() - i - (sum[S.length()] - sum[i]);
            min = Math.min(min, left + right);
        }
        return min;
    }
}
