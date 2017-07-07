package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/smallest-range/
 */
public class Problem632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem632 prob = new Problem632();
        System.out.println(prob.smallestRange(Arrays.asList(
            Arrays.asList(4, 10, 15, 24, 26),
            Arrays.asList(0, 9, 12, 20),
            Arrays.asList(5, 18, 22, 30)
        ))); // [20,24]
    }
}
