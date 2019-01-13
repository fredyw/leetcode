package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class Problem973 {
    public int[][] kClosest(int[][] points, int K) {
        List<PointDistance> list = new ArrayList<>();
        for (int[] point : points) {
            double distance = Math.sqrt((Math.abs(point[0]) * Math.abs(point[0])) +
                (Math.abs(point[1]) * Math.abs(point[1])));
            list.add(new PointDistance(point, distance));
        }
        Collections.sort(list, (a, b) -> {
            if (a.distance < b.distance) {
                return -1;
            } else if (a.distance == b.distance) {
                return 0;
            }
            return 1;
        });
        int[][] answer = new int[K][];
        for (int i = 0; i < K; i++) {
            answer[i] = list.get(i).point;
        }
        return answer;
    }

    private static class PointDistance {
        private final int[] point;
        private final double distance;

        public PointDistance(int[] point, double distance) {
            this.point = point;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return Arrays.toString(point) + " --> " + distance;
        }
    }

    private static void print(int[][] answer) {
        for (int[] i : answer) {
            System.out.print(Arrays.toString(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem973 prob = new Problem973();
        print(prob.kClosest(new int[][]{
            {1, 3}, {-2, 2}
        }, 1)); // [[-2,2]]
        print(prob.kClosest(new int[][]{
            {3, 3}, {5, -1}, {-2, 4}
        }, 2)); // [[3,3],[-2,4]]
    }
}
