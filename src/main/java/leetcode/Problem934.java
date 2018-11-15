package leetcode;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Problem934 {
    public int shortestBridge(int[][] A) {
        int maxRow = A.length;
        int maxCol = maxRow > 0 ? A[0][0] : 0;
        boolean[][] visited1 = new boolean[maxRow][maxCol];
        boolean[][] visited2 = new boolean[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (A[row][col] == 1) {
                    if (!visited1[row][col]) {
                        traverse(A, maxRow, maxCol, row, col, visited1);
                    }
                    if (!visited1[row][col]) {
                        traverse(A, maxRow, maxCol, row, col, visited2);
                    }
                }
            }
        }
        return 0;
    }

    private static void traverse(int[][] a, int maxRow, int maxCol, int row, int col,
                                 boolean[][] visited) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return;
        }
        if (visited[row][col] || a[row][col] == 0) {
            return;
        }
        visited[row][col] = true;
        // top
        traverse(a, maxRow, maxCol, row - 1, col, visited);
        // right
        traverse(a, maxRow, maxCol, row, col + 1, visited);
        // bottom
        traverse(a, maxRow, maxCol, row + 1, col, visited);
        // left
        traverse(a, maxRow, maxCol, row, col - 1, visited);
    }

    public static void main(String[] args) {
        Problem934 prob = new Problem934();
//        System.out.println(prob.shortestBridge(new int[][]{
//            {0, 1},
//            {1, 0}
//        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        })); // 2
//        System.out.println(prob.shortestBridge(new int[][]{
//            {0, 1, 1},
//            {0, 0, 0},
//            {1, 1, 0}
//        })); // 1
//        System.out.println(prob.shortestBridge(new int[][]{
//            {1, 1, 1, 1, 1},
//            {1, 0, 0, 0, 1},
//            {1, 0, 1, 0, 1},
//            {1, 0, 0, 0, 1},
//            {1, 1, 1, 1, 1}
//        })); // 1
    }
}
