package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matrix-block-sum/
 */
public class Problem1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        // TODO
        return null;
    }

    private static void print(int[][] mat) {
        for (int[] m : mat) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void main(String[] args) {
        Problem1314 prob = new Problem1314();
        print(prob.matrixBlockSum(new int[][]{
            {1,2,3},{4,5,6},{7,8,9}
        }, 1)); // [[12,21,16],[27,45,33],[24,39,28]]
        print(prob.matrixBlockSum(new int[][]{
            {1,2,3},{4,5,6},{7,8,9}
        }, 2)); // [[45,45,45],[45,45,45],[45,45,45]]
    }
}
