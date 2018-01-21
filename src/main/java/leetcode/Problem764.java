package leetcode;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class Problem764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int result = 0;
        int[][] grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = 1;
            }
        }
        for (int i = 0; i < mines.length; i++) {
            int[] mine = mines[i];
            int x = mine[0];
            int y = mine[1];
            grid[x][y] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int largest = orderOfLargestPlusSign(N, grid, i, j);
                result = Math.max(result, largest);
            }
        }
        return result;
    }

    private static int orderOfLargestPlusSign(int n, int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        int a = 1;
        if (row - 1 >= 0) {
            for (int i = row - 1; i >= 0; i--) {
                if (grid[i][col] == 0) {
                    break;
                }
                a++;
            }
        }
        int b = 1;
        if (col + 1 < n) {
            for (int i = col + 1; i < n; i++) {
                if (grid[row][i] == 0) {
                    break;
                }
                b++;
            }
        }
        int c = 1;
        if (row + 1 < n) {
            for (int i = row + 1; i < n; i++) {
                if (grid[i][col] == 0) {
                    break;
                }
                c++;
            }
        }
        int d = 1;
        if (col - 1 >= 0) {
            for (int i = col - 1; i >= 0; i--) {
                if (grid[row][i] == 0) {
                    break;
                }
                d++;
            }
        }
        int min = Math.min(Math.min(Math.min(a ,b), c), d);
        return min;
    }

    public static void main(String[] args) {
        Problem764 prob = new Problem764();
//        System.out.println(prob.orderOfLargestPlusSign(5, new int[][]{
//            {4, 2}
//        })); // 2
//        System.out.println(prob.orderOfLargestPlusSign(2, new int[][]{
//        })); // 1
//        System.out.println(prob.orderOfLargestPlusSign(1, new int[][]{
//            {0, 0}
//        })); // 0
//        System.out.println(prob.orderOfLargestPlusSign(1, new int[][]{
//        })); // 1
        System.out.println(prob.orderOfLargestPlusSign(3, new int[][]{
            {0, 2},
            {1, 0},
            {2, 0},
        })); // 1
    }
}
