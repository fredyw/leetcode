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
            int x = random.nextInt(rect[2] - rect[0]) + rect[0];
            int y = random.nextInt(rect[3] - rect[1]) + rect[1];
            return new int[]{x, y};
        }

        private static long area(int[] rect) {
            return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[][]{{1, 1, 5, 5}});
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}
