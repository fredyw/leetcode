package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Problem1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int maxRow = matrix.length;
        int maxCol = maxRow > 0 ? matrix[0].length : 0;
        List<Integer> list = new ArrayList<>();
        int[] xorCols = new int[maxCol];
        for (int row = 0; row < maxRow; row++) {
            int xor = 0;
            for (int col = 0; col < maxCol; col++) {
                if (col == 0) {
                    xor = matrix[row][col];
                } else {
                    xor ^= matrix[row][col];
                }
                if (row == 0) {
                    xorCols[col] = xor;
                } else {
                    xorCols[col] = xor ^ xorCols[col];
                }
                list.add(xorCols[col]);
            }
        }
        Collections.sort(list, (a, b) -> Integer.compare(b, a));
        return list.get(k - 1);
    }
}
