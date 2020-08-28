package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/most-visited-sector-in-a-circular-track/
 */
public class Problem1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1560 prob = new Problem1560();
        System.out.println(prob.mostVisited(4, new int[]{1,3,1,2})); // [1,2]
        System.out.println(prob.mostVisited(2, new int[]{2,1,2,1,2,1,2,1,2})); // [2]
        System.out.println(prob.mostVisited(7, new int[]{1,3,5,7})); // [1,2,3,4,5,6,7]
    }
}
