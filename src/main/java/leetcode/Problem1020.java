package leetcode;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 */
public class Problem1020 {
    public int numEnclaves(int[][] A) {
        int maxRow = A.length;
        int maxCol = A.length > 0 ? A[0].length : 0;
        int answer = 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (visited[i][j] || A[i][j] == 0) {
                    continue;
                }
                BooleanRef ignored = new BooleanRef();
                int n = numEnclaves(A, maxRow, maxCol, i, j, visited, ignored);
                if (ignored.val) {
                    continue;
                }
                answer += n;
            }
        }
        return answer;
    }

    private static class BooleanRef {
        private boolean val;
    }

    private static int numEnclaves(int[][] array, int maxRow, int maxCol, int row, int col,
                                   boolean[][] visited, BooleanRef ignored) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return 0;
        }
        if (visited[row][col] || array[row][col] == 0) {
            return 0;
        }
        if (row == 0 || row == maxRow - 1 || col == 0 || col == maxCol - 1) {
            ignored.val = true;
        }
        visited[row][col] = true;
        int a = numEnclaves(array, maxRow, maxCol, row - 1, col, visited, ignored);
        int b = numEnclaves(array, maxRow, maxCol, row, col + 1, visited, ignored);
        int c = numEnclaves(array, maxRow, maxCol, row + 1, col, visited, ignored);
        int d = numEnclaves(array, maxRow, maxCol, row, col - 1, visited, ignored);
        return a + b + c + d + 1;
    }
}
