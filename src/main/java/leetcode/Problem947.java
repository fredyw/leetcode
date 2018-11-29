package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class Problem947 {
    public int removeStones(int[][] stones) {
        Map<Integer, List<int[]>> xMap = new HashMap<>();
        Map<Integer, List<int[]>> yMap = new HashMap<>();
        for (int[] stone : stones) {
            int x = stone[0];
            if (!xMap.containsKey(x)) {
                List<int[]> list = new ArrayList<>();
                list.add(stone);
                xMap.put(x, list);
            } else {
                xMap.get(x).add(stone);
            }
            int y = stone[1];
            if (!yMap.containsKey(y)) {
                List<int[]> list = new ArrayList<>();
                list.add(stone);
                yMap.put(y, list);
            } else {
                yMap.get(y).add(stone);
            }
        }
        int totalCount = 0;
        Set<String> visited = new HashSet<>();
        for (int[] stone : stones) {
            if (!visited.contains(toString(stone))) {
                IntRef count = new IntRef(0);
                dfs(stone, xMap, yMap, visited, count);
                totalCount += count.val - 1;
            }
        }
        return totalCount;
    }

    private static class IntRef {
        private int val;

        public IntRef(int val) {
            this.val = val;
        }
    }

    private static void dfs(int[] stone,
                            Map<Integer, List<int[]>> xMap,
                            Map<Integer, List<int[]>> yMap,
                            Set<String> visited,
                            IntRef count) {
        count.val++;
        visited.add(toString(stone));
        List<int[]> neighbors = new ArrayList<>();
        neighbors.addAll(xMap.get(stone[0]));
        neighbors.addAll(yMap.get(stone[1]));
        for (int[] adj : neighbors) {
            if (!visited.contains(toString(adj))) {
                dfs(adj, xMap, yMap, visited, count);
            }
        }
    }

    private static String toString(int[] stone) {
        return stone[0] + "," + stone[1];
    }
}
