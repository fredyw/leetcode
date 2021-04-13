package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 */
public class Problem1722 {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        UnionFind uf = new UnionFind();
        for (int[] pair : allowedSwaps) {
            uf.union(source[pair[0]], source[pair[1]]);
        }
        int answer = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i] && !uf.connected(source[i], target[i])) {
                answer++;
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
            int x = find(a);
            int y = find(b);
            if (x != y) {
                map.put(x, y);
            }
        }

        private Integer find(int a) {
            int child = a;
            int parent = map.get(a);
            while (child != parent) {
                child = parent;
                parent = map.get(child);
            }
            return parent;
        }

        private boolean connected(int a, int b) {
            return map.containsKey(a) && map.containsKey(b) && find(a) == find(b);
        }
    }

    public static void main(String[] args) {
        Problem1722 prob = new Problem1722();
//        System.out.println(prob.minimumHammingDistance(
//            new int[]{1,2,3,4}, new int[]{2,1,4,5}, new int[][]{{0,1},{2,3}})); // 1
//        System.out.println(prob.minimumHammingDistance(
//            new int[]{1,2,3,4}, new int[]{1,3,2,4}, new int[][]{})); // 2
//        System.out.println(prob.minimumHammingDistance(
//            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,4},{4,2},{1,3},{1,4}})); // 0
//        System.out.println(prob.minimumHammingDistance(
//            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,3}, new int[][]{{0,3},{3,2},{3,1}})); // 0
//        System.out.println(prob.minimumHammingDistance(
//            new int[]{5,1,2,4,3}, new int[]{1,5,4,2,4}, new int[][]{{0,3},{3,2},{3,1}})); // 1
        System.out.println(prob.minimumHammingDistance(
            new int[]{2,3,1}, new int[]{1,2,2}, new int[][]{{0,2},{1,2}})); // 1
        System.out.println(prob.minimumHammingDistance(
            new int[]{2,3,1,1}, new int[]{1,1,2,2}, new int[][]{{0,2},{1,2}})); // 2
    }
}
