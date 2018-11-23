package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 */
public class Problem939 {
    public int minAreaRect(int[][] points) {
        Set<String> pointSet = new HashSet<>();
        Map<Integer, List<int[]>> xMap = new HashMap<>();
        Map<Integer, List<int[]>> yMap = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!xMap.containsKey(x)) {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                xMap.put(x, list);
            } else {
                xMap.get(x).add(point);
            }

            if (!yMap.containsKey(y)) {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                yMap.put(y, list);
            } else {
                yMap.get(y).add(point);
            }

            pointSet.add(key(point[0], point[1]));
        }
        int area = Integer.MAX_VALUE;
        for (int[] point : points) {
            area = Math.min(area, minAreaRect(point[0], point[1], pointSet, xMap, yMap));
        }
        return area == Integer.MAX_VALUE ? 0 : area;
    }

    private static int minAreaRect(int x, int y,
                                   Set<String> pointSet,
                                   Map<Integer, List<int[]>> xMap,
                                   Map<Integer, List<int[]>> yMap) {
        List<int[]> xPoints = xMap.get(x);
        if (xPoints == null) {
            return Integer.MAX_VALUE;
        }
        List<int[]> yPoints = yMap.get(x);
        if (yPoints == null) {
            return Integer.MAX_VALUE;
        }
        int area = Integer.MAX_VALUE;
        for (int[] xPoint : xPoints) {
            if (xPoint[0] == x && xPoint[1] == y) {
                continue;
            }
            for (int[] yPoint : yPoints) {
                if ((yPoint[0] == x && yPoint[1] == y) ||
                    (yPoint[0] == xPoint[0] && yPoint[1] == xPoint[1])) {
                    continue;
                }
                if (!pointSet.contains(key(yPoint[0], xPoint[1])) ||
                    (yPoint[0] == x && xPoint[1] == y) ||
                    (yPoint[0] == xPoint[0] && xPoint[1] == xPoint[1]) ||
                    (yPoint[0] == yPoint[0] && xPoint[1] == yPoint[1])) {
                    continue;
                }
                area = Math.min(area,
                    Math.abs(xPoint[0] - yPoint[0]) * Math.abs(xPoint[1] - yPoint[1]));
            }
        }
        return area;
    }

    private static String key(int x, int y) {
        return x + "," + y;
    }

    public static void main(String[] args) {
        Problem939 prob = new Problem939();
        // [1, 1], [1, 3], [3, 1], [3, 3]
        System.out.println(prob.minAreaRect(new int[][]{
            {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
        })); // 4
        // [1, 1], [1, 3], [3, 1], [3, 3]
        // [3, 1], [3, 3], [4, 3], [4, 1]
        // [3, 1] --> x = [3, 3]
        //            y = [1, 1], [1, 3]
        //                [4, 1], [4, 3]
        System.out.println(prob.minAreaRect(new int[][]{
            {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
        })); // 2
        System.out.println(prob.minAreaRect(new int[][]{
            {1, 3}, {3, 1}, {3, 3}, {2, 2}
        })); // 0
        // [[3,2],[3,1],[4,4],[1,1],[4,3],[0,3],[0,2],[4,0]]
    }
}
