package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        Map<String, Integer> distanceCounts = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                String key = i + "|" + getDistance(points, i, j);
                if (!distanceCounts.containsKey(key)) {
                    distanceCounts.put(key, 1);
                } else {
                    distanceCounts.put(key, distanceCounts.get(key) + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points, i, j);
                result += distanceCounts.get(i + "|" + distance) - 1;
            }
        }
        return result;
    }

    private static int getDistance(int[][] points, int i, int j) {
        int a = points[i][0] - points[j][0];
        int b = points[i][1] - points[j][1];
        return (a * a) + (b * b);
    }

    public static void main(String[] args) {
        Problem447 prob = new Problem447();
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{1, 4}, {0, 8}, {2, 8}, {4, 5}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}})); // 20
    }
}
