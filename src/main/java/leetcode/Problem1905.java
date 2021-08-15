package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-sub-islands/
 */
public class Problem1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int answer = 0;
        List<Set<String>> islands1 = getIslands(grid1);
        List<Set<String>> islands2 = getIslands(grid2);
        for (Set<String> island1 : islands1) {
            for (Set<String> island2 : islands2) {
                if (island1.containsAll(island2)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private static List<Set<String>> getIslands(int[][] grid) {
        List<Set<String>> islands = new ArrayList<>();
        int maxRow = grid.length;
        int maxCol = grid.length > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                Set<String> island = new HashSet<>();
                getIsland(grid, maxRow, maxCol, visited, island, i, j);
                if (!island.isEmpty()) {
                    islands.add(island);
                }
            }
        }
        return islands;
    }

    private static void getIsland(int[][] grid, int maxRow, int maxCol, boolean[][] visited,
                                  Set<String> island, int row, int col) {
        if (row < 0 || row == maxRow || col < 0 || col == maxCol) {
            return;
        }
        if (grid[row][col] == 0) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        island.add(row + "," + col);
        getIsland(grid, maxRow, maxCol, visited, island, row - 1, col);
        getIsland(grid, maxRow, maxCol, visited, island, row, col + 1);
        getIsland(grid, maxRow, maxCol, visited, island, row + 1, col);
        getIsland(grid, maxRow, maxCol, visited, island, row, col - 1);
    }

    public static void main(String[] args) {
        Problem1905 prob = new Problem1905();
        System.out.println(prob.countSubIslands(new int[][]{
            {1,1,1,0,0},
            {0,1,1,1,1},
            {0,0,0,0,0},
            {1,0,0,0,0},
            {1,1,0,1,1}
        }, new int[][]{
            {1,1,1,0,0},
            {0,0,1,1,1},
            {0,1,0,0,0},
            {1,0,1,1,0},
            {0,1,0,1,0}
        })); // 3
        System.out.println(prob.countSubIslands(new int[][]{
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,0,0,0},
            {1,1,1,1,1},
            {1,0,1,0,1}
        }, new int[][]{
            {0,0,0,0,0},
            {1,1,1,1,1},
            {0,1,0,1,0},
            {0,1,0,1,0},
            {1,0,0,0,1}
        })); // 2
    }
}
