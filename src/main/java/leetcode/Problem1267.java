package leetcode;

/**
 * https://leetcode.com/problems/count-servers-that-communicate/
 */
public class Problem1267 {
    public int countServers(int[][] grid) {
        int answer = 0;
        int nRows = grid.length;
        int nCols = nRows > 0 ? grid[0].length : 0;
        for (int i = 0; i < nRows; i++) {
            int count = 0;
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                answer += count;
            }
        }
        for (int i = 0; i < nCols; i++) {
            int count = 0;
            for (int j = 0; j < nRows; j++) {
                if (grid[j][i] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                answer += count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1267 prob = new Problem1267();
//        System.out.println(prob.countServers(new int[][]{{1,0},{0,1}})); // 0
        System.out.println(prob.countServers(new int[][]{{1,0},{1,1}})); // 3
//        System.out.println(prob.countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}})); // 4
    }
}
