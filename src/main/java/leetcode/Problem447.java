package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distanceCounts = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points, i, j);
                if (!distanceCounts.containsKey(distance)) {
                    distanceCounts.put(distance, 1);
                } else {
                    distanceCounts.put(distance, distanceCounts.get(distance) + 1);
                }
            }
            for (Map.Entry<Integer, Integer> entries : distanceCounts.entrySet()) {
                result += entries.getValue() * (entries.getValue() - 1);
            }
        }
        return result;
    }

    private static int getDistance(int[][] points, int i, int j) {
        int a = points[i][0] - points[j][0];
        int b = points[i][1] - points[j][1];
        return (a * a) + (b * b);
    }
}
