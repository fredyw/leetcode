package leetcode;

/**
 * https://leetcode.com/problems/champagne-tower/
 */
public class Problem799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[100][100];
        glasses[0] = new double[]{poured};
        for (int row = 0; row <= query_row; row++) {
            for (int col = 0; col < glasses[row].length; col++) {
                double val = glasses[row][col];
                if (val > 1) {
                    glasses[row][col] = 1;
                    double half = (val - 1) / 2;
                    glasses[row + 1][col] += half;
                    glasses[row + 1][col + 1] += half;
                }
            }
        }
        return Math.min(1, glasses[query_row][query_glass]);
    }
}
