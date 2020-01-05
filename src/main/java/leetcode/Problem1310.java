package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/xor-queries-of-a-subarray/
 */
public class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1310 prob = new Problem1310();
        System.out.println(Arrays.toString(prob.xorQueries(new int[]{1,3,4,8}, new int[][]{
            {0,1},{1,2},{0,3},{3,3}
        }))); // [2,7,14,8]
        System.out.println(Arrays.toString(prob.xorQueries(new int[]{4,8,2,10}, new int[][]{
            {2,3},{1,3},{0,0},{0,3}
        }))); // [8,0,4,4]
    }
}
