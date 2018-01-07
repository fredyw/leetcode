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
            for (int j = K - 1; j >= 0; j--) {
                if (heights[j] < heights[index]) {
                    found = true;
                    index = j;
                }
            }
            if (found) {
                heights[index]++;
                continue outer;
            }

            // right
            index = K;
            found = false;
            for (int j = K + 1; j < heights.length; j++) {
                if (heights[j] < heights[index]) {
                    found = true;
                    index = j;
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
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 1, 3))); // [2,1,2,2,1,2,2]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{1, 2, 3, 4}, 2, 2))); // [2,3,3,4]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{3, 1, 3}, 5, 1))); // [4,4,4]
//        System.out.println(Arrays.toString(prob.pourWater(new int[]{2, 1, 2, 3, 1, 2, 2}, 1, 3))); // [2,2,2,3,1,2,2]
        System.out.println(Arrays.toString(prob.pourWater(new int[]{1, 2, 3, 4, 3, 2, 1, 2, 3, 4, 3, 2, 1}, 2, 5))); // [1,2,3,4,3,3,2,2,3,4,3,2,1]
    }
}
