package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/
 */
public class Problem1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1828 prob = new Problem1828();
        System.out.println(Arrays.toString(prob.countPoints(new int[][]{
            {1,3},{3,3},{5,3},{2,2}
        }, new int[][]{
            {2,3,1},{4,3,1},{1,1,2}
        }))); // [3,2,2]
        System.out.println(Arrays.toString(prob.countPoints(new int[][]{
            {1,1},{2,2},{3,3},{4,4},{5,5}
        }, new int[][]{
            {1,2,2},{2,2,2},{4,3,2},{4,3,3}
        }))); // [2,3,2,4]
    }
}
