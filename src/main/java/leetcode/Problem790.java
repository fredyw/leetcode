package leetcode;

/**
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 */
public class Problem790 {
    public int numTilings(int N) {
        long[] a = new long[1001];
        a[1] = 1;
        a[2] = 2;
        a[3] = 5;
        if (N <= 3) {
            return (int) a[N];
        }
        for (int i = 4; i <= N; ++i) {
            a[i] = 2 * a[i - 1] + a[i - 3];
            a[i] %= 1e9 + 7;
        }
        return (int) a[N];
    }
}
