package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/snakes-and-ladders/
 */
public class Problem909 {
    public int snakesAndLadders(int[][] board) {
        int[] b = new int[(board.length * board.length) + 1];
        int i = 1;
        boolean leftToRight = true;
        for (int row = board.length - 1; row >= 0; row--) {
            if (leftToRight) {
                for (int col = 0; col < board.length; col++) {
                    b[i] = board[row][col];
                    i++;
                }
            } else {
                for (int col = board.length - 1; col >= 0; col--) {
                    b[i] = board[row][col];
                    i++;
                }
            }
            leftToRight = !leftToRight;
        }
        int answer = 0;
        int target = board.length * board.length;
        boolean[] visited = new boolean[b.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        outer:
        while (!queue.isEmpty()) {
            Queue<Integer> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int current = queue.remove();
                if (visited[current]) {
                    continue;
                }
                visited[current] = true;
                if (current == target) {
                    return answer;
                }
                for (int step = 1; step <= 6; step++) {
                    int newStep = current + step;
                    if (newStep < b.length) {
                        if (b[newStep] != -1) {
                            tmp.add(b[newStep]);
                        } else {
                            tmp.add(newStep);
                        }
                    }
                }
            }
            answer++;
            queue.addAll(tmp);
        }
        return -1;
    }
}
