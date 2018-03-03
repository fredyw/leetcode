package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/escape-the-ghosts/
 */
public class Problem789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance1 = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            distance1 = Math.min(distance1, shortestPath(ghost, target, new HashSet<>()));
        }
        int distance2 = shortestPath(new int[]{0, 0}, target, new HashSet<>());
        return distance2 < distance1;
    }

    private static int shortestPath(int[] source, int[] target, Set<String> visited) {
        Map<String, String> pathTo = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(source);
        outer:
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            String currentKey = buildKey(current);
            visited.add(currentKey);
            String targetKey = buildKey(target);
            if (currentKey.equals(targetKey)) {
                break outer;
            }
            for (int[] adj : adjacents(current)) {
                String adjKey = buildKey(adj);
                if (!visited.contains(adjKey)) {
                    queue.add(adj);
                    pathTo.put(adjKey, currentKey);
                    visited.add(adjKey);
                }
            }
        }
        int count = 0;
        String s = pathTo.get(buildKey(target));
        while (s != null) {
            s = pathTo.get(s);
            count++;
        }
        return count;
    }

    private static String buildKey(int[] a) {
        return a[0] + "|" + a[1];
    }

    private static List<int[]> adjacents(int[] source) {
        List<int[]> adjacents = new ArrayList<>();
        adjacents.add(new int[]{source[0] - 1, source[1]});
        adjacents.add(new int[]{source[0], source[1] + 1});
        adjacents.add(new int[]{source[0] + 1, source[1]});
        adjacents.add(new int[]{source[0], source[1] - 1});
        return adjacents;
    }

    public static void main(String[] args) {
        Problem789 prob = new Problem789();
        System.out.println(prob.escapeGhosts(new int[][]{
            {1, 0},
            {0, 3}
        }, new int[]{0, 1})); // true
        System.out.println(prob.escapeGhosts(new int[][]{
            {1, 0},
        }, new int[]{2, 0})); // false
        System.out.println(prob.escapeGhosts(new int[][]{
            {2, 0},
        }, new int[]{1, 0})); // false
        System.out.println(prob.escapeGhosts(new int[][]{
            {-10, -9}, {5, 0}, {-7, -3}, {-6, -1}, {-4, -7}
        }, new int[]{7, -2})); // false
        System.out.println(prob.escapeGhosts(new int[][]{
            {25, 94}, {-30, 59}, {94, 78}, {37, -34}, {33, -29}, {-98, 53}, {79, -47}, {92, 50}, {80, 60}, {93, 56}
        }, new int[]{80, 34})); // false
    }
}
