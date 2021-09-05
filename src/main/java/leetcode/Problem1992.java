package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland/
 */
public class Problem1992 {
    public int[][] findFarmland(int[][] land) {
        // TODO
        return null;
    }

    private static void print(int[][] arr) {
        for (int[] a : arr) {
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        Problem1992 prob = new Problem1992();
        print(prob.findFarmland(new int[][]{
            {1,0,0},{0,1,1},{0,1,1}
        })); // [[0,0,0,0],[1,1,2,2]]
        print(prob.findFarmland(new int[][]{
            {1,1},{1,1}
        })); // [[0,0,1,1]]
        print(prob.findFarmland(new int[][]{
            {0}
        })); // []
    }
}
