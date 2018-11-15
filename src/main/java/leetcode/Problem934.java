package leetcode;

/**
 * https://leetcode.com/problems/shortest-bridge/
 */
public class Problem934 {
    public int shortestBridge(int[][] A) {
        int maxRow = A.length;
        int maxCol = maxRow > 0 ? A[0][0] : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (visited[row][col]) {
                    continue;
                }
                // TODO
            }
        }
        return 0;
    }

    private static void shortest(int[][] a, int maxRow, int maxCol, int row, int col) {
        // top
        if (row - 1 >= 0) {

        }
        // right
        if (col + 1 < maxCol) {

        }
        // bottom
        if (row + 1 < maxRow) {

        }
        // left
        if (col - 1 >= 0) {

        }
    }

    public static void main(String[] args) {
        Problem934 prob = new Problem934();
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1},
            {1, 0}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 0},
            {0, 0, 0},
            {0, 0, 1}
        })); // 2
        System.out.println(prob.shortestBridge(new int[][]{
            {0, 1, 1},
            {0, 0, 0},
            {1, 1, 0}
        })); // 1
        System.out.println(prob.shortestBridge(new int[][]{
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
        })); // 1
    }
}
