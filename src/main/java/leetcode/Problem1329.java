package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 */
public class Problem1329 {
    public int[][] diagonalSort(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = maxRow > 0 ? mat[0].length : 0;
        for (int i = 0; i < maxRow; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int row = i, col = 0; row < maxRow && col < maxCol; row++, col++) {
                tmp.add(mat[row][col]);
            }
            Collections.sort(tmp);
            int index = 0;
            for (int row = i, col = 0; row < maxRow && col < maxCol; row++, col++) {
                mat[row][col] = tmp.get(index++);
            }
        }
        for (int i = 1; i < maxCol; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int row = 0, col = i; row < maxRow && col < maxCol; row++, col++) {
                tmp.add(mat[row][col]);
            }
            Collections.sort(tmp);
            int index = 0;
            for (int row = 0, col = i; row < maxRow && col < maxCol; row++, col++) {
                mat[row][col] = tmp.get(index++);
            }
        }
        return mat;
    }
}
