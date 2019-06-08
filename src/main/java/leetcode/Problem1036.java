package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/escape-a-large-maze/
 */
public class Problem1036 {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockedSet = new HashSet<>();
        for (int[] b : blocked) {
            blockedSet.add(toString(b));
        }
        return isEscapePossible(blockedSet, source, target, 1_000_000, 1_000_000) &&
            isEscapePossible(blockedSet, target, source, 1_000_000, 1_000_000);
    }

    private static boolean isEscapePossible(Set<String> blocked, int[] source,
                                            int[] target, int maxRow, int maxCol) {
        Set<String> visited = new HashSet<>();
        Stack<int[]> coordinates = new Stack<>();
        coordinates.add(source);
        while (!coordinates.isEmpty()) {
            int[] pop = coordinates.pop();
            if (pop[0] == target[0] && pop[1] == target[1]) {
                return true;
            }
            if ((pop[0] < 0 || pop[0] == maxRow) || (pop[1] < 0 || pop[1] == maxCol)) {
                continue;
            }
            String key = toString(pop);
            if (blocked.contains(key) || visited.contains(key)) {
                continue;
            }
            visited.add(key);
            if (visited.size() > 20000) {
                return true;
            }
            for (int[] a : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                coordinates.add(new int[]{pop[0] + a[0], pop[1] + a[1]});
            }
        }
        return false;
    }

    private static String toString(int[] a) {
        return a[0] + "," + a[1];
    }
}
