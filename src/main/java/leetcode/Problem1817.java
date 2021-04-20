package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 */
public class Problem1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1817 prob = new Problem1817();
        System.out.println(Arrays.toString(prob.findingUsersActiveMinutes(
            new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5
        ))); // [0,2,0,0,0]
        System.out.println(Arrays.toString(prob.findingUsersActiveMinutes(
            new int[][]{{1,1},{2,2},{2,3}}, 4
        ))); // [1,1,0,0]
    }
}
