package leetcode;

/**
 * https://leetcode.com/problems/maximal-network-rank/
 */
public class Problem1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] counts = new int[n];
        boolean[][] connected = new boolean[n][n];
        for (int[] road : roads) {
            counts[road[0]]++;
            counts[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer = Math.max(answer, counts[i] + counts[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return answer;
    }
}
