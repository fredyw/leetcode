package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland/
 */
public class Problem1992 {
    public int[][] findFarmland(int[][] land) {
        List<int[]> farmlands = new ArrayList<>();
        int maxRow = land.length;
        int maxCol = land.length > 0 ? land[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (land[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                BottomRight bottomRight = new BottomRight();
                findFarmland(land, maxRow, maxCol, i, j, visited, bottomRight);
                farmlands.add(new int[]{i, j, bottomRight.row, bottomRight.col});
            }
        }
        int[][] answer = new int[farmlands.size()][4];
        for (int i = 0; i < farmlands.size(); i++) {
            answer[i] = farmlands.get(i);
        }
        return answer;
    }

    private static class BottomRight {
        private int row;
        private int col;
    }

    private static void findFarmland(int[][] land, int maxRow, int maxCol,
                                     int row, int col, boolean[][] visited,
                                     BottomRight bottomRight) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (land[row][col] == 0 || visited[row][col]) {
            return;
        }
        if (row + col >= bottomRight.row + bottomRight.col) {
            bottomRight.row = row;
            bottomRight.col = col;
        }
        visited[row][col] = true;
        findFarmland(land, maxRow, maxCol, row - 1, col, visited, bottomRight);
        findFarmland(land, maxRow, maxCol, row, col + 1, visited, bottomRight);
        findFarmland(land, maxRow, maxCol, row + 1, col, visited, bottomRight);
        findFarmland(land, maxRow, maxCol, row, col - 1, visited, bottomRight);
    }
}
