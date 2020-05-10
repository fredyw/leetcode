package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
 */
public class Problem1443 {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            tree[from].add(to);
        }
        IntRef answer = new IntRef();
        minTime(tree, hasApple, 0, answer);
        return Math.max(0, answer.value - 1);
    }

    private static class IntRef {
        private int value;
    }

    private static boolean minTime(List<Integer>[] tree,
                                   List<Boolean> hasApple,
                                   int node,
                                   IntRef time) {
        boolean found = hasApple.get(node);
        for (int children : tree[node]) {
            time.value++;
            found |= minTime(tree, hasApple, children, time);
        }
        if (found) {
            time.value++;
        } else {
            time.value = Math.max(0, time.value - 1);
        }
        return found;
    }
}
