package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class Problem684 {
    public int[] findRedundantConnection(int[][] edges) {
        // TODO
        return new int[0];
    }

    private static class UnionFind {
        private final Map<Integer, Integer> map = new HashMap<>();

        public void union(int a, int b) {
            if (!map.containsKey(a)) {
                map.put(a, a);
            }
            if (!map.containsKey(b)) {
                map.put(b, b);
            }
            if (!connected(a, b)) {
                return;
            }
            int value = map.get(a);
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue().equals(value)) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }

        public boolean connected(int a, int b) {
            return map.get(a).equals(map.get(b));
        }
    }

    public static void main(String[] args) {
        Problem684 prob = new Problem684();
        System.out.println(prob.findRedundantConnection(new int[][]{
            {1, 2}, {1, 3}, {2, 3}
        })); // [2,3]
        System.out.println(prob.findRedundantConnection(new int[][]{
            {1,2}, {2,3}, {3,4}, {1,4}, {1,5}
        })); // [1,4]
    }
}
