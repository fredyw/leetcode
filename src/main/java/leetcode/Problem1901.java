package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-a-peak-element-ii/
 */
public class Problem1901 {
    public int[] findPeakGrid(int[][] mat) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1901 prob = new Problem1901();
        System.out.println(Arrays.toString(prob.findPeakGrid(new int[][]{
            {1,4},
            {3,2}
        }))); // [0,1]
        System.out.println(Arrays.toString(prob.findPeakGrid(new int[][]{
            {10,20,15},
            {21,30,14},
            {7,16,32}
        }))); // [1,1]
    }
}
