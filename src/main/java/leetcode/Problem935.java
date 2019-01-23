package leetcode;

/**
 * https://leetcode.com/problems/knight-dialer/
 */
public class Problem935 {
    public int knightDialer(int N) {
        int[][] moves = new int[10][];
        moves[0] = new int[]{4, 6};
        moves[1] = new int[]{6, 8};
        moves[2] = new int[]{7, 9};
        moves[3] = new int[]{4, 8};
        moves[4] = new int[]{0, 3, 9};
        moves[5] = new int[]{};
        moves[6] = new int[]{0, 1, 7};
        moves[7] = new int[]{2, 6};
        moves[8] = new int[]{1, 3};
        moves[9] = new int[]{2, 4};
        Long[][] memo = new Long[N + 1][10];
        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer += knightDialer(moves, i, N - 1, memo) % (1_000_000_000 + 7);
        }
        return (int) (answer % (1_000_000_000 + 7));
    }

    private static long knightDialer(int[][] moves, int position, int n, Long[][] memo) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][position] != null) {
            return memo[n][position];
        }
        long count = 0;
        for (int move : moves[position]) {
            count += knightDialer(moves, move, n - 1, memo) % (1_000_000_000 + 7);
        }
        memo[n][position] = count;
        return count;
    }
}
