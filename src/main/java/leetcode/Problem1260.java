package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid/
 */
public class Problem1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        for (int shift = 0; shift < k; shift++) {
            int[][] tmp = new int[maxRow][maxCol];
            // the last column
            tmp[0][0] = grid[maxRow - 1][maxCol - 1];
            for (int row = 0; row < maxRow - 1; row++) {
                tmp[row + 1][0] = grid[row][maxCol - 1];
            }
            // shift all the columns
            for (int row = 0; row < maxRow; row++) {
                for (int col = maxCol - 1; col > 0; col--) {
                    tmp[row][col] = grid[row][col - 1];
                }
            }

            grid = tmp;
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < maxRow; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < maxCol; j++) {
                list.add(grid[i][j]);
            }
            answer.add(list);
        }
        return answer;
    }
}
