package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
 */
public class Problem1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1557 prob = new Problem1557();
        System.out.println(prob.findSmallestSetOfVertices(6, Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(0, 2),
            Arrays.asList(2, 5),
            Arrays.asList(3, 4),
            Arrays.asList(4, 2)
        ))); // [0,3]
        System.out.println(prob.findSmallestSetOfVertices(5, Arrays.asList(
            Arrays.asList(0, 1),
            Arrays.asList(2, 1),
            Arrays.asList(3, 1),
            Arrays.asList(1, 4),
            Arrays.asList(2, 4)
        ))); // [0,2,3]
    }
}
