package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/queries-on-a-permutation-with-key/
 */
public class Problem1409 {
    public int[] processQueries(int[] queries, int m) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1409 prob = new Problem1409();
        System.out.println(Arrays.toString(prob.processQueries(new int[]{3,1,2,1}, 5))); // [2,1,2,1]
        System.out.println(Arrays.toString(prob.processQueries(new int[]{4,1,2,2}, 4))); // [3,1,2,0]
        System.out.println(Arrays.toString(prob.processQueries(new int[]{7,5,5,8,3}, 8))); // [6,5,0,7,5]
    }
}
