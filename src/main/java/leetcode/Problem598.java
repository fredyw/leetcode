package leetcode;

/**
 * https://leetcode.com/problems/range-addition-ii/
 */
public class Problem598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int rowSize = 0;
        int colSize = 0;
        for (int i = 0; i < ops.length; i++) {
            if (i == 0) {
                rowSize = ops[i][0];
                colSize = ops[i][1];
            } else {
                rowSize = Math.min(rowSize, ops[i][0]);
                colSize = Math.min(colSize, ops[i][1]);
            }
        }
        return rowSize * colSize;
    }
}
