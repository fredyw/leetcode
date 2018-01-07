package leetcode;

/**
 * https://leetcode.com/problems/pour-water/
 */
public class Problem755 {
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
                } else if (heights[j] > heights[index]) {
                    break;
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
                } else if (heights[j] > heights[index]) {
                    break;
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
}
