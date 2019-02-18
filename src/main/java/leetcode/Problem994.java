package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 */
public class Problem994 {
    public int orangesRotting(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = maxRow > 0 ? grid[0].length : 0;
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int val = bfs(grid, maxRow, maxCol, i, j);
                    if (val > 0) {
                        answer = Math.min(answer, val);
                    }
                }
            }
        }
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static int bfs(int[][] grid, int maxRow, int maxCol, int row, int col) {
        int count = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            Queue<int[]> tmp = new LinkedList<>();
            count++;
            while (!queue.isEmpty()) {
                int[] current = queue.remove();
                row = current[0];
                col = current[1];
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    tmp.add(new int[]{row - 1, col});
                }
                if (col + 1 < maxCol && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    tmp.add(new int[]{row, col + 1});
                }
                if (row + 1 < maxRow && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    tmp.add(new int[]{row + 1, col});
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    tmp.add(new int[]{row, col - 1});
                }
            }
            queue.addAll(tmp);
        }
        return count;
    }

    public static void main(String[] args) {
        Problem994 prob = new Problem994();
//        System.out.println(prob.orangesRotting(new int[][]{
//            {2, 1, 1},
//            {1, 1, 0},
//            {0, 1, 1}
//        })); // 4
//        System.out.println(prob.orangesRotting(new int[][]{
//            {2, 1, 1},
//            {0, 1, 1},
//            {1, 0, 1}
//        })); // -1
//        System.out.println(prob.orangesRotting(new int[][]{
//            {0, 2}
//        })); // 0
//        System.out.println(prob.orangesRotting(new int[][]{
//            {1, 0, 1}
//        })); // -1
//        System.out.println(prob.orangesRotting(new int[][]{
//            {0, 1}
//        })); // -1
//        System.out.println(prob.orangesRotting(new int[][]{
//            {0}
//        })); // 0
//        System.out.println(prob.orangesRotting(new int[][]{
//            {2, 2, 2, 1, 1}
//        })); // 2
        System.out.println(prob.orangesRotting(new int[][]{
            {2, 2},
            {1, 1},
            {0, 0},
            {2, 0}
        })); // 1
    }
}
