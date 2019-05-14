package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 */
public class Problem1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1042 prob = new Problem1042();
        System.out.println(Arrays.toString(prob.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))); // [1,2,3]
        System.out.println(Arrays.toString(prob.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}}))); // [1,2,1,2]
        System.out.println(Arrays.toString(prob.gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}}))); // [1,2,3,4]
    }
}
