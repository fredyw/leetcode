package leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 */
public class Problem526 {
    public int countArrangement(int N) {
        boolean[] processed = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            processed[i - 1] = false;
        }
        IntRef result = new IntRef();
        countArrangement(N, processed, 1, result);
        return result.ref;
    }

    private static class IntRef {
        int ref;
    }

    private static void countArrangement(int n,
                                         boolean[] processed,
                                         int count,
                                         IntRef result) {
        if (count > n) {
            result.ref++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (processed[i]) {
                continue;
            }
            if (i % count == 0 || count % i == 0) {
                processed[i] = true;
                countArrangement(n, processed, count + 1, result);
                // backtracking
                processed[i] = false;
            }
        }
    }
}
