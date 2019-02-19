package leetcode;

import java.util.ArrayList;
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
                int area = area(rects[i]);
                if (area > 0) {
                    this.rects.add(rects[i]);
                }
            }
        }

        public int[] pick() {
            int index = random.nextInt(rects.size());
            int[] rect = rects.get(index);
            return null;
        }

        private static int area(int[] rect) {
            return (rect[0] - rect[2]) * (rect[1] * rect[3]);
        }
    }

    public static void main(String[] args) {

    }
}
