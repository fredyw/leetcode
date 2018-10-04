package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/image-overlap/
 */
public class Problem835 {
    public int largestOverlap(int[][] A, int[][] B) {
        int maxRow = A.length;
        int maxCol = (A.length > 0) ? A[0].length : 0;
        List<int[]> list = new ArrayList<>();
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (A[row][col] == 1) {
                    list.add(new int[]{row, col});
                }
            }
        }
        int max = 0;
        for (int down = 0; down < maxRow; down++) {
            for (int right = 0; right < maxCol; right++) {
                int count = 0;
                for (int[] cell : list) {
                    int row = cell[0] + down;
                    int col = cell[1] + right;
                    if (row < maxRow && col < maxCol && B[row][col] == 1) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            for (int left = maxCol; left >= 0; left--) {
                int count = 0;
                for (int[] cell : list) {
                    int row = cell[0] + down;
                    int col = cell[1] - left;
                    if (row < maxRow && col >= 0 && B[row][col] == 1) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        for (int up = maxRow - 1; up >= 0; up--) {
            for (int right = 0; right < maxCol; right++) {
                int count = 0;
                for (int[] cell : list) {
                    int row = cell[0] - up;
                    int col = cell[1] + right;
                    if (row >= 0 && col < maxCol && B[row][col] == 1) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
            for (int left = maxCol; left >= 0; left--) {
                int count = 0;
                for (int[] cell : list) {
                    int row = cell[0] - up;
                    int col = cell[1] - left;
                    if (row >= 0 && col >= 0 && B[row][col] == 1) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
