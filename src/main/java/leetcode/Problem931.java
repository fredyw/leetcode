package leetcode;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class Problem931 {
    public int minFallingPathSum(int[][] A) {
        int maxRow = A.length;
        int maxCol = A.length > 0 ? A[0].length : 0;
        int min = Integer.MAX_VALUE;
//        for (int col = 0; col < maxCol; col++) {
//            min = Math.min(min, minFaillingPathSum(A, maxRow, maxCol, 0, col));
//        }
        min = Math.min(min, minFaillingPathSum(A, maxRow, maxCol, 0, 0));
        return min;
    }

    private static int minFaillingPathSum(int[][] a, int maxRow, int maxCol, int row, int col) {
        if (row < 0 || col < 0 || row >= maxRow || col >= maxCol) {
            return 0;
        }
        int value = a[row][col];
        int min = Integer.MAX_VALUE;
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col - 1) + value);
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col) + value);
        min = Math.min(min, minFaillingPathSum(a, maxRow, maxCol, row + 1, col + 1) + value);
        return min;
    }

    public static void main(String[] args) {
        Problem931 prob = new Problem931();
        System.out.println(prob.minFallingPathSum(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        })); // 12
    }
}
