package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class Problem1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1202 prob = new Problem1202();
        System.out.println(prob.smallestStringWithSwaps(
            "dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2)))); // "abcd"
        System.out.println(prob.smallestStringWithSwaps(
            "dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2)))); // "abcd"
        System.out.println(prob.smallestStringWithSwaps(
            "cba", Arrays.asList(Arrays.asList(0, 1), Arrays.asList(1, 2)))); // "abc"
        System.out.println(prob.smallestStringWithSwaps(
            "edcab", Arrays.asList(Arrays.asList(1, 4), Arrays.asList(2, 3)))); // "ebacd"
    }
}
