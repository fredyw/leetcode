package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class Problem973 {
    public int[][] kClosest(int[][] points, int K) {
        List<PointDistance> list = new ArrayList<>();
        for (int[] point : points) {
            int sqrtDist = (Math.abs(point[0]) * Math.abs(point[0])) +
                (Math.abs(point[1]) * Math.abs(point[1]));
            list.add(new PointDistance(point, sqrtDist));
        }
        Collections.sort(list, (a, b) -> {
            if (a.sqrtDist < b.sqrtDist) {
                return -1;
            } else if (a.sqrtDist == b.sqrtDist) {
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
        private final int sqrtDist;

        public PointDistance(int[] point, int sqrtDist) {
            this.point = point;
            this.sqrtDist = sqrtDist;
        }
    }
}
