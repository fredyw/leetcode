package leetcode;

/**
 * https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/
 */
public class Problem1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        int maxRow = matrix.length;
        int maxCol = maxRow > 0 ? matrix[0].length : 0;
        int xor1 = 0;
        for (int row = 0; row < maxRow; row++) {
            int xor2 = 0;
            for (int col = 0; col < maxCol; col++) {
                if (col == 0) {
                    xor2 = matrix[row][col];
                } else {
                    xor2 ^= matrix[row][col];
                }
            }
            if (row == 0) {
                xor1 = xor2;
            } else {
                xor1 ^= xor2;
            }
        }
        xor1 = 0;
        for (int col = 0; col < maxCol; col++) {
            int xor2 = 0;
            for (int row = 0; row < maxRow; row++) {
                if (col == 0) {
                    xor2 = matrix[row][col];
                } else {
                    xor2 ^= matrix[row][col];
                }
            }
            if (col == 0) {
                xor1 = xor2;
            } else {
                xor1 ^= xor2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem1738 prob = new Problem1738();
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 1)); // 7
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 2)); // 5
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 3)); // 4
        System.out.println(prob.kthLargestValue(new int[][]{
            {5,2},{1,6}
        }, 4)); // 0
    }
}
