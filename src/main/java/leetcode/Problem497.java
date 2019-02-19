package leetcode;

import java.util.Random;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 */
public class Problem497 {
    private static class Solution {
        private final TreeMap<Integer, int[]> map = new TreeMap<>();
        private final Random random = new Random();
        private int area;

        public Solution(int[][] rect) {
            for (int i = 0; i < rect.length; i++) {
                area += area(rect[i]);
                map.put(area, rect[i]);
            }
        }

        public int[] pick() {
            int key = map.ceilingKey(random.nextInt(area) + 1);
            int[] rect = map.get(key);
            int x = random.nextInt(rect[2] - rect[0] + 1) + rect[0];
            int y = random.nextInt(rect[3] - rect[1] + 1) + rect[1];
            return new int[]{x, y};
        }

        private static int area(int[] rect) {
            return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }
}
