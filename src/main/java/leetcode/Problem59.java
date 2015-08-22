package leetcode;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        Direction[] directions = new Direction[]{
            Direction.LEFT, Direction.DOWN, Direction.RIGHT, Direction.UP
        };
        int dirIdx = 0;
        int row = 0;
        int col = 0;
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = matrix.length;
        int colEnd = matrix[row].length;
        int number = 1;
        do {
            if (dirIdx == directions.length) {
                dirIdx = 0;
            }
            switch (directions[dirIdx]) {
            case LEFT:
                row = rowBegin;
                col = colBegin;
                while (col < colEnd) {
                    matrix[row][col] = number++;
                    col++;
                }
                rowBegin++;
                col--;
                break;
            case DOWN:
                row++;
                while (row < rowEnd) {
                    matrix[row][col] = number++;
                    row++;
                }
                colEnd--;
                row--;
                break;
            case RIGHT:
                col--;
                while (col >= colBegin) {
                    matrix[row][col] = number++;
                    col--;
                }
                rowEnd--;
                col++;
                break;
            case UP:
                row--;
                while (row >= rowBegin) {
                    matrix[row][col] = number++;
                    row--;
                }
                colBegin++;
                break;
            }
            dirIdx++;
        } while (rowBegin != rowEnd && colBegin != colEnd);
        return matrix;
    }
    
    private static enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}
