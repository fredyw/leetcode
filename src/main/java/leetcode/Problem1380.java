package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/lucky-numbers-in-a-matrix/
 */
public class Problem1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int maxRow = matrix.length;
        int maxCol = matrix.length > 0 ? matrix[0].length : 0;
        for (int row = 0; row < maxRow; row++) {
            int min = Integer.MAX_VALUE;
            int minRowIndex = 0;
            int minColIdx = 0;
            for (int col = 0; col < maxCol; col++) {
                if (matrix[row][col] < min) {
                    min = matrix[row][col];
                    minRowIndex = row;
                    minColIdx = col;
                }
            }
            set.add(minRowIndex + "," + minColIdx);
        }
        for (int col = 0; col < maxCol; col++) {
            int max = 0;
            int maxRowIndex = 0;
            int maxColIndex = 0;
            for (int row = 0; row < maxRow; row++) {
                if (matrix[row][col] > max) {
                    max = matrix[row][col];
                    maxRowIndex = row;
                    maxColIndex = col;
                }
            }
            if (set.contains(maxRowIndex + "," + maxColIndex)) {
                answer.add(max);
            }
        }
        return answer;
    }
}
