package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 */
public class Problem1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        int[][] rowSums = new int[maxRow][maxCol];
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (col - 1 < 0) {
                    rowSums[row][col] = mat[row][col];
                } else {
                    rowSums[row][col] = rowSums[row][col - 1] + mat[row][col];
                }
            }
        }
        int[][] colSums = new int[maxRow][maxCol];
        for (int col = 0; col < maxCol; col++) {
            for (int row = 0; row < maxRow; row++) {
                if (row - 1 < 0) {
                    colSums[row][col] = mat[row][col];
                } else {
                    colSums[row][col] += colSums[row - 1][col] + mat[row][col];
                }
            }
        }
        int answer = 0;
        Map<String, Integer> sums = new HashMap<>();
        for (int row = maxRow - 1; row >= 0; row--) {
            for (int col = maxCol - 1; col >= 0; col--) {
                for (int side = 0; side < Math.min(maxRow, maxCol) && row - side >= 0 && col - side >= 0; side++) {
                    if (side == 0) {
                        sums.put(key(row, col, row, col), mat[row][col]);
                    } else {
                        int row1 = row - side;
                        int col1 = col - side;
                        int row2 = row;
                        int col2 = col;
                        int r = rowSums[row1][col2] - (col1 - 1 < 0 ? 0 : rowSums[row1][col1 - 1]);
                        int c = colSums[row2][col1] - (row1 - 1 < 0 ? 0 : colSums[row1 - 1][col1]);
                        int sum = r + c - mat[row1][col1] + sums.getOrDefault(key(row1 + 1, col1 + 1, row2, col2), 0);
                        sums.put(key(row1, col1, row2, col2), sum);
                        answer = Math.max(answer, sum <= threshold ? row2 - row1 + 1 : 0);
                    }
                }
            }
        }
        return answer;
    }

    private static String key(int row1, int col1, int row2, int col2) {
        return row1 + "," + col1 + "," + row2 + "," + col2;
    }

    public static void main(String[] args) {
        Problem1292 prob = new Problem1292();
        System.out.println(prob.maxSideLength(new int[][]{
            {1, 1, 3, 2, 4, 3, 2},
            {1, 1, 3, 2, 4, 3, 2},
            {1, 1, 3, 2, 4, 3, 2}
        }, 4)); // 2
        System.out.println(prob.maxSideLength(new int[][]{
            {1, 1},
            {1, 1},
            {1, 1}
        }, 4)); // 2
        System.out.println(prob.maxSideLength(new int[][]{
            {2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2},
            {2, 2, 2, 2, 2}
        }, 1)); // 0
        System.out.println(prob.maxSideLength(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 0}
        }, 6)); // 3
        System.out.println(prob.maxSideLength(new int[][]{
            {18, 70},
            {61, 1},
            {25, 85},
            {14, 40},
            {11, 96},
            {97, 96},
            {63, 45}
        }, 40184)); // 2
        System.out.println(prob.maxSideLength(new int[][]{
            {18, 70},
            {61, 1}
        }, 4)); // 1
        System.out.println(prob.maxSideLength(new int[][]{
            {18, 70},
            {61, 5}
        }, 4)); // 0
    }
}
