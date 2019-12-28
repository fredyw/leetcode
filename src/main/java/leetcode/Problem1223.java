package leetcode;

/**
 * https://leetcode.com/problems/dice-roll-simulation/
 */
public class Problem1223 {
    public int dieSimulator(int n, int[] rollMax) {
        int[][][] memo = new int[5000][6][16];
        return dieSimulator(n, rollMax, -1, 0, memo);
    }

    private static int dieSimulator(int n, int[] rollMax, int last, int currentLength,
                                    int[][][] memo) {
        if (n == 0) {
            return 1;
        }
        if (last >= 0 && memo[n][last][currentLength] > 0) {
            return memo[n][last][currentLength];
        }
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (i == last && currentLength == rollMax[i]) {
                continue;
            }
            count = (count + dieSimulator(n - 1, rollMax, i, i == last ? currentLength + 1 : 1, memo)) % 1_000_000_007;
        }
        if (last >= 0) {
            memo[n][last][currentLength] = count;
        }
        return count;
    }
}
