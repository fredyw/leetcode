package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-center-of-star-graph/
 */
public class Problem1791 {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            if (map.containsKey(edge[0])) {
                return edge[0];
            } else {
                map.put(edge[0], 1);
            }
            if (map.containsKey(edge[1])) {
                return edge[1];
            } else {
                map.put(edge[1], 1);
            }
        }
        // Can never happen.
        return 0;
    }
}
