package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 */
public class Problem1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Dist[] dists = new Dist[R * C];
        int index = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r0 - r) + Math.abs(c0 - c);
                dists[index++] = new Dist(r, c, dist);
            }
        }
        Arrays.sort(dists, Comparator.comparingInt(a -> a.dist));
        int[][] answer = new int[dists.length][2];
        for (int i = 0; i < dists.length; i++) {
            answer[i] = new int[]{dists[i].row, dists[i].col};
        }
        return answer;
    }

    private static class Dist {
        private final int row;
        private final int col;
        private final int dist;

        public Dist(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
