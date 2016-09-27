package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class Problem406 {
    public int[][] reconstructQueue(int[][] people) {
        List<Height> heights = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int h = people[i][0];
            int k = people[i][1];
            heights.add(new Height(h, k));
        }
        Collections.sort(heights, (a, b) -> {
            if (a.h == b.h) {
                return Integer.compare(b.k, a.k);
            }
            return Integer.compare(a.h, b.h);
        });
        int[][] result = new int[people.length][2];
        TreeSet<Integer> indices = new TreeSet<>();
        for (int i = 0; i < people.length; i++) {
            indices.add(i);
        }
        for (Height height : heights) {
            int target = height.k;
            int idx = 0;
            int step = 0;
            for (int i : indices) {
                if (step == target) {
                    idx = i;
                    break;
                }
                step++;
            }
            result[idx][0] = height.h;
            result[idx][1] = height.k;
            indices.remove(idx);
        }
        return result;
    }

    private static class Height {
        private final int h;
        private final int k;

        public Height(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
}
