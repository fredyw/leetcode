package leetcode;

/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 */
public class Problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid.length > 0 ? grid[0].length : 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Make sure this is a square.
                for (int k = 1; k <= Math.min(m, n) && i + k <= m && j + k <= n; k++) {
                    if (isValid(grid, i, j, k)) {
                        answer = Math.max(answer, k * k);
                    }
                }
            }
        }
        return answer;
    }

    private static boolean isValid(int[][] grid, int i, int j, int k) {
        for (int row = i; row < i + k; row++) {
            if (grid[row][j] == 0 || grid[row][j + k - 1] == 0) {
                return false;
            }
        }
        for (int col = j; col < j + k; col++) {
            if (grid[i][col] == 0 || grid[i + k - 1][col] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1139 prob = new Problem1139();
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        })); // 9
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 0, 0},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        })); // 4
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
        })); // 1
        System.out.println(prob.largest1BorderedSquare(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
        })); // 16
    }
}
