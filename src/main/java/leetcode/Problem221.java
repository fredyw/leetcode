package leetcode;

/**
 * https://leetcode.com/problems/maximal-square/
 */
public class Problem221 {
    public int maximalSquare(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int x1 = col;
                int y1 = row;
                int x2 = x1;
                int y2 = y1;
                while (y2 < matrix.length && x2 < matrix[row].length) {
                    Square square = isSquare(matrix, x1, y1, x2, y2);
                    if (!square.square) {
                        break;
                    }
                    max = Math.max(max, square.val);
                    x2++;
                    y2++;
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    private static class Square {
        boolean square;
        int val;

        public Square(boolean square, int val) {
            this.square = square;
            this.val = val;
        }
    }

    private Square isSquare(char[][] matrix, int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int row = y1; row <= y2; row++) {
            for (int col = x1; col <= x2; col++) {
                if (matrix[row][col] != '1') {
                    return new Square(false, sum);
                } else {
                    sum++;
                }
            }
        }
        return new Square(true, sum);
    }
}
