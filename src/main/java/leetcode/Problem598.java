package leetcode;

/**
 * https://leetcode.com/problems/range-addition-ii/
 */
public class Problem598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
            return m * n;
        }
        int[][] matrix = new int[m][n];
        int max = 0;
        int count = 0;
        for (int x = 0; x < ops.length; x++) {
            int[] op = ops[x];
            for (int i = 0; i < op[0]; i++) {
                for (int j = 0; j < op[1]; j++) {
                    matrix[i][j]++;
                    if (max < matrix[i][j]) {
                        max = matrix[i][j];
                        count = 1;
                    } else if (max == matrix[i][j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem598 prob = new Problem598();
        System.out.println(prob.maxCount(3, 3, new int[][]{
            {2, 2},
            {3, 3}
        })); // 4
        System.out.println(prob.maxCount(3, 3, new int[][]{
            {2, 1},
            {1, 3}
        })); // 1
        System.out.println(prob.maxCount(3, 3, new int[][]{
        })); // 9
        System.out.println(prob.maxCount(39999, 39999, new int[][]{
            {19999,  19999}
        })); // 399960001
    }
}
