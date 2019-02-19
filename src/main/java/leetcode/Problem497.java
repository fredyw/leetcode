package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/
 */
public class Problem497 {
    private static class Solution {
        private final List<int[]> rects = new ArrayList<>();
        private final Random random = new Random();

        public Solution(int[][] rects) {
            for (int i = 0; i < rects.length; i++) {
                long area = area(rects[i]);
                if (area > 0) {
                    this.rects.add(rects[i]);
                }
            }
        }

        public int[] pick() {
            int index = random.nextInt(rects.size());
            int[] rect = rects.get(index);
            int minX = Integer.min(rect[0], rect[2]);
            int maxX = Integer.max(rect[0], rect[2]);
            int minY = Integer.min(rect[1], rect[3]);
            int maxY = Integer.max(rect[1], rect[3]);

            int x = random.nextInt(maxX - minX) + minX;
            int y = random.nextInt(maxY - minY) + minY;
            return new int[]{x, y};
        }

        private static long area(int[] rect) {
            long minX = Integer.min(rect[0], rect[2]);
            long maxX = Integer.max(rect[0], rect[2]);
            long minY = Integer.min(rect[1], rect[3]);
            long maxY = Integer.max(rect[1], rect[3]);
            return (maxX - minX) * (maxY * minY);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{1, 1, 5, 5}});
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}
