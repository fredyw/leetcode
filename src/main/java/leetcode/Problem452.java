package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> {
            int comp = Integer.compare(a[0], b[0]);
            if (comp == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return comp;
        });
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + ":" + points[i][1]);
        }
        int end1 = points[0][1];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            int start2 = points[i][0];
            int end2 = points[i][1];
            if (start2 > end1) {
                result++;
                end1 = end2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem452 prob = new Problem452();
//        System.out.println(prob.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}})); // 2
//        System.out.println(prob.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 9}})); // 3
//        System.out.println(prob.findMinArrowShots(new int[][]{{1, 6}, {7, 8}, {9, 10}})); // 3
//        System.out.println(prob.findMinArrowShots(new int[][]{{1, 6}, {7, 8}, {8, 10}})); // 2
//        System.out.println(prob.findMinArrowShots(new int[][]{{1, 6}})); // 1
//        System.out.println(prob.findMinArrowShots(new int[][]{})); // 0
//        System.out.println(prob.findMinArrowShots(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}})); // 2
        System.out.println(prob.findMinArrowShots(new int[][]{{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}})); // 2
    }
}
