package leetcode;

/**
 * https://leetcode.com/problems/spiral-matrix-iii/
 */
public class Problem885 {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int size = R * C;
        int[][] result = new int[size][2];
        int count = 1;
        int index = 0;
        int row = r0;
        int col = c0;
        Direction[] directions = new Direction[]{
            Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP};
        int directionIndex = 0;
        result[index][0] = row;
        result[index][1] = col;
        index++;
        int steps = 1;
        while (count < size) {
            for (int i = 0; i < steps; i++) {
                switch (directions[directionIndex]) {
                    case LEFT:
                        col--;
                        break;
                    case DOWN:
                        row++;
                        break;
                    case UP:
                        row--;
                        break;
                    case RIGHT:
                        col++;
                        break;
                }
                if (withinBoundary(R, C, row, col)) {
                    result[index][0] = row;
                    result[index][1] = col;
                    index++;
                    count++;
                }
            }
            if (directions[directionIndex] == Direction.DOWN ||
                directions[directionIndex] == Direction.UP) {
                steps++;
            }
            directionIndex++;
            directionIndex = directionIndex % directions.length;
        }
        return result;
    }

    private enum Direction {
        RIGHT, DOWN, LEFT, UP
    }

    private static boolean withinBoundary(int maxRow, int maxCol, int row, int col) {
        return !(row < 0 || row >= maxRow || col < 0 || col >= maxCol);
    }
}
