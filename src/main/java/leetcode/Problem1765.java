package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/map-of-highest-peak/
 */
public class Problem1765 {
    public int[][] highestPeak(int[][] isWater) {
        int maxRow = isWater.length;
        int maxCol = maxRow > 0 ? isWater[0].length : 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            for (int[] adjacent : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int row = current[0] + adjacent[0];
                int col = current[1] + adjacent[1];
                if (row < 0 || row == maxRow || col < 0 || col == maxCol
                    || visited[row][col]) {
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for (int[] adj : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int adjRow = row + adj[0];
                    int adjCol = col + adj[1];
                    if (adjRow < 0 || adjRow == maxRow || adjCol < 0 || adjCol == maxCol
                        || !visited[adjRow][adjCol]) {
                        continue;
                    }
                    min = Math.min(min, isWater[adjRow][adjCol]);
                }
                isWater[row][col] = min + 1;
                visited[row][col] = true;
                queue.add(new int[]{row, col});
            }
        }
        return isWater;
    }
}
