package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 */
public class Problem624 {
    public int maxDistance(List<List<Integer>> arrays) {
        // TODO:
        return 0;
    }

    public static void main(String[] args) {
        Problem624 prob = new Problem624();
        System.out.println(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 3)
        )); // 4
        System.out.println(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 10)
        )); // 9
        System.out.println(Arrays.asList(
            Arrays.asList(2, 3, 4),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 10)
        )); // 8
    }
}
