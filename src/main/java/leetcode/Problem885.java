package leetcode;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class Problem885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int size = R * C;
        int[][] result = new int[size][2];
        int count = 0;
        int index = 0;
        int row = r0;
        int col = c0;
        Direction direction = Direction.LEFT;
        result[index][0] = row;
        result[index][1] = col;
        index++;
        while (count < size) {
            if (withinBoundary(R, C, row, col)) {
                result[index][0] = row;
                result[index][1] = col;
                index++;
            }
        }
        return result;
    }

    private enum Direction {
        LEFT, DOWN, RIGHT, UP
    }

    private static boolean withinBoundary(int maxRow, int maxCol, int row, int col) {
        return !(row < 0 || row >= maxRow || col < 0 || col >= maxCol);
    }

    public static void main(String[] args) {
        Problem885 prob = new Problem885();
        System.out.println(prob.spiralMatrixIII(1, 4, 0, 0)); // [[0,0],[0,1],[0,2],[0,3]]
        System.out.println(prob.spiralMatrixIII(5, 6, 1, 4)); // [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
    }
}
