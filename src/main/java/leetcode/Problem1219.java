package leetcode;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 */
public class Problem1219 {
    public int getMaximumGold(int[][] grid) {
        int answer = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                answer = Math.max(answer,
                    getMaximumGold(grid, row, col, new boolean[grid.length][grid[row].length]));
            }
        }
        return answer;
    }

    private static int getMaximumGold(int[][] grid, int row, int col, boolean[][] visited) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return 0;
        }
        if (grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int a = getMaximumGold(grid, row - 1, col, visited); // up
        int b = getMaximumGold(grid, row, col + 1, visited); // right
        int c = getMaximumGold(grid, row + 1, col, visited); // down
        int d = getMaximumGold(grid, row, col - 1, visited); // left
        int max = grid[row][col] + Math.max(a, Math.max(b, Math.max(c, d)));
        return max;
    }

    public static void main(String[] args) {
        Problem1219 prob = new Problem1219();
        System.out.println(prob.getMaximumGold(new int[][]{
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        })); // 24
        System.out.println(prob.getMaximumGold(new int[][]{
            {1, 0, 7},
            {2, 0, 6},
            {3, 4, 5},
            {0, 3, 0},
            {9, 0, 20}
        })); // 28
        System.out.println(prob.getMaximumGold(new int[][]{
            {1, 0, 7, 0, 0, 0},
            {2, 0, 6, 0, 1, 0},
            {3, 5, 6, 7, 4, 2},
            {4, 3, 1, 0, 2, 0},
            {3, 0, 5, 0, 20, 0}
        })); // 60
    }
}
