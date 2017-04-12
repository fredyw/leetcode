package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/brick-wall/
 */
public class Problem554 {
    public int leastBricks(List<List<Integer>> wall) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem554 prob = new Problem554();
        System.out.println(prob.leastBricks(Arrays.asList(
            Arrays.asList(1, 2, 2, 1),
            Arrays.asList(3, 1, 2),
            Arrays.asList(1, 3, 2),
            Arrays.asList(2, 4),
            Arrays.asList(3, 1, 2),
            Arrays.asList(1, 3, 3, 1)
        ))); // 2
    }
}
