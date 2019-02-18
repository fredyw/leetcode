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
        boolean found = false;
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
                    found = true;
                    break outer;
                }
                for (int step = 1; step <= 6; step++) {
                    int newStep = current + step;
                    if (newStep < b.length) {
                        if (b[newStep] > 0) {
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
        return !found ? -1 : answer;
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
//        System.out.println(prob.snakesAndLadders(new int[][]{
//            {1, 1, -1},
//            {1, 1, 1},
//            {-1, 1, 1}
//        })); // -1
        System.out.println(prob.snakesAndLadders(new int[][]{
            {-1, -1, 19, 10, -1},
            {2, -1, -1, 6, -1},
            {-1, 17, -1, 19, -1},
            {25, -1, 20, -1, -1},
            {-1, -1, -1, -1, 15}
        })); // 2
//        System.out.println(prob.snakesAndLadders(new int[][]{
//            {-1, -1, 30, 14, 15, -1},
//            {23, 9, -1, -1, -1, 9},
//            {12, 5, 7, 24, -1, 30},
//            {10, -1, -1, -1, 25, 17},
//            {32, -1, 28, -1, -1, 32},
//            {-1, -1, 23, -1, 13, 19}
//        })); // 2
//        System.out.println(prob.snakesAndLadders(new int[][]{
//            {-1, -1}, {-1, 3}
//        })); // 1
//        System.out.println(prob.snakesAndLadders(new int[][]{
//            {-1, -1, -1, -1, 48, 5, -1},
//            {12, 29, 13, 9, -1, 2, 32},
//            {-1, -1, 21, 7, -1, 12, 49},
//            {42, 37, 21, 40, -1, 22, 12},
//            {42, -1, 2, -1, -1, -1, 6},
//            {39, -1, 35, -1, -1, 39, -1},
//            {-1, 36, -1, -1, -1, -1, 5}
//        })); // 3
        System.out.println(prob.snakesAndLadders(new int[][]{
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {25, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1}
        })); // 2
        System.out.println(prob.snakesAndLadders(new int[][]{
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1},
            {-1, -1, -1, -1, 25}
        })); // 1
    }
}
