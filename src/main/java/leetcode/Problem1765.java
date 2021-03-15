package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/map-of-highest-peak/
 */
public class Problem1765 {
    public int[][] highestPeak(int[][] isWater) {
        // TODO
        return null;
    }

    private static void print(int[][] array) {
        for (int[] a : array) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Problem1765 prob = new Problem1765();
        print(prob.highestPeak(new int[][]{
            {0, 1},
            {0, 0}
        })); // [[1,0],[2,1]]
        print(prob.highestPeak(new int[][]{
            {0, 0, 1},
            {1, 0, 0},
            {0, 0, 0}
        })); // [[1,1,0],[0,1,1],[1,2,2]]
    }
}
