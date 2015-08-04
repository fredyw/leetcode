package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Problem64 {
    //    public int minPathSum(int[][] grid) {
    //    	int min = Integer.MAX_VALUE;
    //    	Map<String, Integer> memo = new HashMap<>();
    //    	for (int col = 0; col < grid[0].length; col++) {
    //    		min = Math.min(min, minPathSum(grid, 0, col, memo));
    //    	}
    //    	return min;
    //    }
    //    
    //    private int minPathSum(int[][] grid, int row, int col, Map<String, Integer> memo) {
    //    	if (memo.containsKey(row + "|" + col)) {
    //    		return memo.get(row + "|" + col);
    //    	}
    //    	if (grid.length-1 == row) {
    //    		return grid[row][col];
    //    	}
    //    	int val = grid[row][col];
    //    	int a = minPathSum(grid, row+1, col, memo);
    //    	int min = val + a;
    //    	if (col+1 < grid[row].length) {
    //    		int b = minPathSum(grid, row, col+1, memo);
    //    		min = Math.min(val+a,  val+b);
    //    	}
    //    	memo.put(row + "|" + col, min);
    //    	return min;
    //    }

    public int minPathSum(int[][] grid) {
        Map<String, Integer> memo = new HashMap<>();
        return minPathSum(grid, 0, 0, memo);
    }

    private int minPathSum(int[][] grid, int row, int col, Map<String, Integer> memo) {
        if (grid.length-1 == row && grid[row].length-1 == col) {
            return grid[row][col];
        }
        if (memo.containsKey(row + "|" + col)) {
            return memo.get(row + "|" + col);
        }
        int min = Integer.MAX_VALUE;
        if (row+1 < grid.length) {
            int val = grid[row][col];
            int a = minPathSum(grid, row+1, col, memo) + val;
            min = Math.min(a, min);
        }
        if (col+1 < grid[row].length) {
            int val = grid[row][col];
            int b = minPathSum(grid, row, col+1, memo) + val;
            min = Math.min(b, min);
        }
        memo.put(row + "|" + col, min);
        return min;
    }
}
