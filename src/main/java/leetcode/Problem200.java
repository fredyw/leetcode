package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class Problem200 {
    public int numIslands(char[][] grid) {
        Set<String> zeroes = new HashSet<>();
        Set<String> ones = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    ones.add(buildKey(row, col));
                } else {
                    zeroes.add(buildKey(row, col));
                }
            }
        }
        int result = 0;
        while (!ones.isEmpty()) {
            String[] str = ones.iterator().next().split("\\|");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            numIslands(grid, row, col, zeroes, ones);
            result++;
        }
        return result;
    }

    private void numIslands(char[][] grid, int row, int col, Set<String> zeroes, Set<String> ones) {
        String key = buildKey(row, col);
        if (!zeroes.contains(key) && !ones.contains(key)) {
            return;
        }
        if (grid[row][col] == '0') {
            zeroes.remove(key);
            return;
        }
        ones.remove(key);
        numIslands(grid, row - 1, col, zeroes, ones); // up
        numIslands(grid, row + 1, col, zeroes, ones); // down
        numIslands(grid, row, col - 1, zeroes, ones); // left
        numIslands(grid, row, col + 1, zeroes, ones); // right
    }

    private String buildKey(int row, int col) {
        return row + "|" + col;
    }
}
