package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/pour-water/
 */
public class Problem756 {
    public int[] pourWater(int[] heights, int V, int K) {
        outer:
        for (int i = 0; i < V; i++) {
            // left
            for (int j = K; j >= 0; j--) {
                int left = (j - 1 < 0) ? Integer.MIN_VALUE : heights[j - 1];
                if (heights[j] < left) {
                    heights[j]++;
                    continue outer;
                }
            }
            // right
            for (int j = K; j < heights.length; j++) {
                int right = (j + 1 < heights.length) ? Integer.MIN_VALUE : heights[j + 1];
                if (heights[j] < right) {
                    heights[j]++;
                    continue outer;
                }
            }
            heights[K]++;
        }
        return heights;
    }

    public static void main(String[] args) {
        Problem756 prob = new Problem756();
        System.out.println(Arrays.toString(prob.pourWater(new int[] { 2, 1, 2, 2, 1, 2, 2 }, 1, 3))); // [2,2,2,2,1,2,2]
//        System.out.println(Arrays.toString(prob.pourWater(new int[] { 2, 1, 1, 2, 1, 2, 2 }, 4, 3))); // [2,2,2,3,2,2,2]
//        System.out.println(Arrays.toString(prob.pourWater(new int[] { 1, 2, 3, 4 }, 2, 2))); // [2,3,3,4]
//        System.out.println(Arrays.toString(prob.pourWater(new int[] { 3, 1, 3 }, 5, 1))); // [4,4,4]
    }
}
