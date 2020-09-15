package leetcode;

/**
 * https://leetcode.com/problems/special-positions-in-a-binary-matrix/
 */
public class Problem1582 {
    public int numSpecial(int[][] mat) {
        int answer = 0;
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        boolean[][] processed = new boolean[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (mat[row][col] == 1 && !processed[row][col]) {
                    processed[row][col] = true;
                    boolean duplicate = false;
                    // up
                    for (int r = row - 1; r >= 0; r--) {
                        if (mat[r][col] == 1) {
                            processed[r][col] = true;
                            duplicate = true;
                        }
                    }
                    // right
                    for (int c = col + 1; c < maxCol; c++) {
                        if (mat[row][c] == 1) {
                            processed[row][c] = true;
                            duplicate = true;
                        }
                    }
                    // down
                    for (int r = row + 1; r < maxRow; r++) {
                        if (mat[r][col] == 1) {
                            processed[r][col] = true;
                            duplicate = true;
                        }
                    }
                    // left
                    for (int c = col - 1; c >= 0; c--) {
                        if (mat[row][c] == 1) {
                            processed[row][c] = true;
                            duplicate = true;
                        }
                    }
                    if (!duplicate) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
