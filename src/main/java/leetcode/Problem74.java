package leetcode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Problem74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        int size = nRow * nCol;
        int lo = 0;
        int hi = size;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid == size) {
                return false;
            }
            int val = getValue(matrix, mid, nCol);
            if (target == val) {
                return true;
            } else if (val > target) {
                hi = mid - 1;
            } else { // val < target
                lo = mid + 1;
            }
        }
        return false;
    }
    
    private int getValue(int[][] matrix, int idx, int nCol) {
        int row = idx / nCol;
        int col = idx % nCol;
        return matrix[row][col];
    }
}
