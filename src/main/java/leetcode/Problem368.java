package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset/
 */
public class Problem368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem368 prob = new Problem368();
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 3})); // [1, 2]
        System.out.println(prob.largestDivisibleSubset(new int[]{1, 2, 4, 8})); // [1 ,2, 4, 8]
    }
}
