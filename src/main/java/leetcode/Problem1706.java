package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/where-will-the-ball-fall/
 */
public class Problem1706 {
    public int[] findBall(int[][] grid) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1706 prob = new Problem1706();
        System.out.println(Arrays.toString(prob.findBall(new int[][]{
            {1,1,1,-1,-1},
            {1,1,1,-1,-1},
            {-1,-1,-1,1,1},
            {1,1,1,1,-1},
            {-1,-1,-1,-1,-1}
        }))); // [1,-1,-1,-1,-1]
        System.out.println(Arrays.toString(prob.findBall(new int[][]{
            {-1}
        }))); // [-1]
        System.out.println(Arrays.toString(prob.findBall(new int[][]{
            {1,1,1,1,1,1},
            {-1,-1,-1,-1,-1,-1},
            {1,1,1,1,1,1},
            {-1,-1,-1,-1,-1,-1}
        }))); // [0,1,2,3,4,-1]
    }
}
