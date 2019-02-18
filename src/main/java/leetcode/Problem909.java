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
        }
        int answer = 0;
        int target = board.length * board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        outer:
        while (!queue.isEmpty()) {
            Queue<Integer> tmp = new LinkedList<>();
            answer++;
            while (!queue.isEmpty()) {
                int current = queue.remove();
                if (current == target) {
                    break outer;
                }
                for (int step = 1; step <= 6; step++) {
                    int newStep = current + step;
                    if (newStep < b.length) {
                        if (b[newStep] >= 0) {
                            tmp.add(b[newStep]);
                        } else {
                            tmp.add(newStep);
                        }
                    }
                }
            }
            queue.addAll(tmp);
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        Problem909 prob = new Problem909();
//        System.out.println(prob.snakesAndLadders(new int[][]{
//            {-1, -1, -1, -1, -1, -1},
//            {-1, -1, -1, -1, -1, -1},
//            {-1, -1, -1, -1, -1, -1},
//            {-1, 35, -1, -1, 13, -1},
//            {-1, -1, -1, -1, -1, -1},
//            {-1, 15, -1, -1, -1, -1}
//        })); // 4
        System.out.println(prob.snakesAndLadders(new int[][]{
            {1, 1, -1},
            {1, 1, 1},
            {-1, 1, 1}
        })); // -1
    }
}
