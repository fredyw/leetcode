package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 */
public class Problem1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind uf = new UnionFind();
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
        private final Map</* child */ Integer, /* parent */ Integer> map = new HashMap<>();

        private void union(int a, int b) {
            if (!map.containsKey(a)) {
                map.put(a, a);
            }
            if (!map.containsKey(b)) {
                map.put(b, b);
            }
            int rootA = find(a);
            int rootY = find(b);
            if (rootA != rootY) {
                map.put(rootA, rootY);
            }
        }

        private int find(int a) {
            Integer child = a;
            Integer parent = map.get(a);
            while (child != null && !child.equals(parent)) {
                child = parent;
                parent = map.get(child);
            }
            return parent == null ? a : parent;
        }
    }

    public static void main(String[] args) {
        Problem1722 prob = new Problem1722();
        System.out.println(prob.minimumHammingDistance(
            new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}})); // 1
        System.out.println(prob.minimumHammingDistance(
            new int[]{1,2,3,4}, new int[]{1,3,2,4}, new int[][]{})); // 2
        System.out.println(prob.minimumHammingDistance(
            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}})); // 0
        System.out.println(prob.minimumHammingDistance(
            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,3},{3,2},{3,1}})); // 0
        System.out.println(prob.minimumHammingDistance(
            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,4}, new int[][]{{0,3},{3,2},{3,1}})); // 1
        System.out.println(prob.minimumHammingDistance(
            new int[]{2,3,1}, new int[]{1,2,2}, new int[][]{{0,2},{1,2}})); // 1
        System.out.println(prob.minimumHammingDistance(
            new int[]{2,3,1,1}, new int[]{1,1,2,2}, new int[][]{{0,2},{1,2}})); // 2
    }
}
