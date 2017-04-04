package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/friend-circles/
 */
public class Problem547 {
    public int findCircleNum(int[][] M) {
        UnionFind uf = new UnionFind();
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return new HashSet<>(uf.map.values()).size();
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
            if (map.get(a) == map.get(b)) {
                return; // already connected
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue().equals(map.get(a))) {
                    map.put(e.getKey(), map.get(b));
                }
            }
        }
    }
}
