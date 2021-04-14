package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 */
public class Problem1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind uf = new UnionFind(source.length);
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }
        Map</* root */ Integer, Map</* num */ Integer, /* count */ Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int root = uf.find(i);
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> countMap = map.get(root);
            countMap.put(source[i], countMap.getOrDefault(source[i], 0) + 1);
        }
        int answer = 0;
        for (int i = 0; i < source.length; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> countMap = map.get(root);
            if (!countMap.containsKey(target[i])) {
                answer++;
            } else {
                int newCount = countMap.get(target[i]) - 1;
                if (newCount == 0) {
                    countMap.remove(target[i]);
                } else {
                    countMap.put(target[i], newCount);
                }
            }
        }
        return answer;
    }

    private static class UnionFind {
        private final Integer[] parents; // child to parent

        private UnionFind(int n) {
            parents = new Integer[n];
        }

        private void union(int a, int b) {
            if (parents[a] == null) {
                parents[a] = a;
            }
            if (parents[b] == null) {
                parents[b] = b;
            }
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parents[rootA] = rootB;
            }
        }

        private int find(int a) {
            Integer child = a;
            Integer parent = parents[child];
            while (parent != null && !child.equals(parent)) {
                child = parent;
                parent = parents[child];
            }
            return parent == null ? a : parent;
        }
    }
}
