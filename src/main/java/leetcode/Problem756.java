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
            int index = K;
            boolean found = false;
            for (int j = K; j > 0; j--) {
                int left = heights[j - 1];
                if (heights[j] > left) {
                    found = true;
                    index = left;
                }
            }
            if (found) {
                heights[index]++;
                continue outer;
            }

            // right
            index = K;
            found = false;
            for (int j = K; j < heights.length - 1; j++) {
                int right = heights[j + 1];
                if (heights[j] > right) {
                    found = true;
                    index = right;
                }
            }
            if (found) {
                heights[index]++;
                continue outer;
            }

            heights[K]++;
        }
        return heights;
    }

    public static void main(String[] args) {
        Problem756 prob = new Problem756();
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 2, 2, 1, 2, 2}, 1, 3))); // [2,2,2,2,1,2,2]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3))); // [2,2,2,3,2,2,2]
        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 1, 3))); // [2,1,2,2,1,2,2]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{1, 2, 3, 4}, 2, 2))); // [2,3,3,4]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{3, 1, 3}, 5, 1))); // [4,4,4]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 2, 3, 1, 2, 2}, 1, 3))); // [2,2,2,3,1,2,2]
    }
}
