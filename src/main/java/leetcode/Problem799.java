package leetcode;

/**
 * https://leetcode.com/problems/champagne-tower/
 */
public class Problem799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[100][100];
        int row = 0;
        glasses[row] = new double[]{poured};
        while (row < glasses.length) {
            int colIdx = 0;
            boolean overflow = false;
            for (int col = 0; col < glasses[row].length; col++) {
                double val = glasses[row][col];
                if (val == 0) {
                    break;
                }
                if (val > 1) {
                    glasses[row][col] = 1;
                    double half = (val - 1) / 2;
                    glasses[row + 1][colIdx++] += half;
                    glasses[row + 1][colIdx++] += half;
                    overflow = true;
                }
            }
            if (!overflow) {
                break;
            }
            row++;
        }
        return glasses[query_row][query_glass];
    }

    public static void main(String[] args) {
        Problem799 prob = new Problem799();
//        System.out.println(prob.champagneTower(1, 1, 1)); // 0.0
//        System.out.println(prob.champagneTower(2, 1, 1)); // 0.5
//        System.out.println(prob.champagneTower(3, 0, 0)); // 1.0
//        System.out.println(prob.champagneTower(3, 1, 1)); // 1.0
//        System.out.println(prob.champagneTower(3, 2, 0)); // 0.0
//        System.out.println(prob.champagneTower(3, 2, 1)); // 0.0
//        System.out.println(prob.champagneTower(4, 2, 0)); // 0.25
//        System.out.println(prob.champagneTower(4, 1, 0)); // 1.0
//        System.out.println(prob.champagneTower(4, 1, 1)); // 1.0
        System.out.println(prob.champagneTower(4, 2, 1)); // 0.5
    }
}
