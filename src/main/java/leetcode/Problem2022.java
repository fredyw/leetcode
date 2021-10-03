package leetcode;

/**
 * https://leetcode.com/problems/convert-1d-array-into-2d-array/
 */
public class Problem2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        int[][] answer = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = original[index++];
            }
        }
        return answer;
    }
}
