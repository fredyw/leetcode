package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 */
public class Problem1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1443 prob = new Problem1443();
        System.out.println(prob.minTime(
            7,
            new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
            Arrays.asList(false,false,true,false,true,true,false))); // 8
        System.out.println(prob.minTime(
            7,
            new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
            Arrays.asList(false,false,true,false,false,true,false))); // 6
        System.out.println(prob.minTime(
            7,
            new int[][]{{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}},
            Arrays.asList(false,false,false,false,false,false,false))); // 0
    }
}
