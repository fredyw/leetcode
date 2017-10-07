package leetcode;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 */
public class Problem688 {
    public double knightProbability(int N, int K, int r, int c) {
        // TODO
        // (-2, -1), (-1, -2), (1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1)
        return 0;
    }

    public static void main(String[] args) {
        Problem688 prob = new Problem688();
        System.out.println(prob.knightProbability(3, 2, 0, 0)); // 0.0625
        System.out.println(prob.knightProbability(3, 3, 0, 0)); // 0.01563
    }
}
