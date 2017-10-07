package leetcode;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 */
public class Problem688 {
    public double knightProbability(int N, int K, int r, int c) {
        Double[][][] memo = new Double[K + 1][N][N];
        return knightProbability(N, K, r, c, memo);
    }

    private static double knightProbability(int n, int k, int row, int col,
                                            Double[][][] memo) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (memo[k][row][col] != null) {
            return memo[k][row][col];
        }
        // (-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)
        double a = knightProbability(n, k - 1, row - 2, col - 1, memo);
        double b = knightProbability(n, k - 1, row - 1, col - 2, memo);
        double c = knightProbability(n, k - 1, row + 1, col - 2, memo);
        double d = knightProbability(n, k - 1, row + 2, col - 1, memo);
        double e = knightProbability(n, k - 1, row + 2, col + 1, memo);
        double f = knightProbability(n, k - 1, row + 1, col + 2, memo);
        double g = knightProbability(n, k - 1, row - 1, col + 2, memo);
        double h = knightProbability(n, k - 1, row - 2, col + 1, memo);
        double sum = a + b + c + d + e + f + g + h;
        double probability = sum / 8.0;
        memo[k][row][col] = probability;
        return probability;
    }
}
