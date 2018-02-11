package leetcode;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class Problem779 {
    public int kthGrammar(int N, int K) {
        int[] cols = new int[N];
        cols[N - 1] = K;
        for (int row = N - 2; row >= 0; row--) {
            cols[row] = (int) Math.ceil(cols[row + 1] / 2.0);
        }
        int result = 0;
        for (int row = 1; row < N; row++) {
            int i = cols[row];
            String s = "";
            if (result == 0) {
                s = "01";
            } else {
                s = "10";
            }

            if (i % 2 == 0) {
                result = s.charAt(1) - '0';
            } else {
                result = s.charAt(0) - '0';
            }
        }
        return result;
    }
}
