package leetcode;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 */
public class Problem1267 {
    public int countServers(int[][] grid) {
        int answer = 0;
        int nRows = grid.length;
        int nCols = nRows > 0 ? grid[0].length : 0;
        boolean[][] visited = new boolean[nRows][nCols];
        for (int i = 0; i < nRows; i++) {
            int count = 0;
            boolean[] tmp = new boolean[nCols];
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == 1) {
                    tmp[j] = true;
                    count++;
                }
            }
            if (count > 1) {
                visited[i] = tmp;
                answer += count;
            }
        }
        for (int i = 0; i < nCols; i++) {
            int count = 0;
            int nVisited = 0;
            for (int j = 0; j < nRows; j++) {
                if (grid[j][i] == 1) {
                    if (visited[j][i]) {
                        nVisited++;
                    }
                    count++;
                }
            }
            if (count > 1) {
                answer += count - nVisited;
            }
        }
        return answer;
    }
}
