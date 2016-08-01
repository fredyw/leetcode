package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
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
        do {
            if (dirIdx == directions.length) {
                dirIdx = 0;
            }
            switch (directions[dirIdx]) {
                case LEFT:
                    row = rowBegin;
                    col = colBegin;
                    while (col < colEnd) {
                        result.add(matrix[row][col]);
                        col++;
                    }
                    rowBegin++;
                    col--;
                    break;
                case DOWN:
                    row++;
                    while (row < rowEnd) {
                        result.add(matrix[row][col]);
                        row++;
                    }
                    colEnd--;
                    row--;
                    break;
                case RIGHT:
                    col--;
                    while (col >= colBegin) {
                        result.add(matrix[row][col]);
                        col--;
                    }
                    rowEnd--;
                    col++;
                    break;
                case UP:
                    row--;
                    while (row >= rowBegin) {
                        result.add(matrix[row][col]);
                        row--;
                    }
                    colBegin++;
                    break;
            }
            dirIdx++;
        } while (rowBegin != rowEnd && colBegin != colEnd);
        return result;
    }

    private static enum Direction {
        LEFT, RIGHT, UP, DOWN
    }
}
