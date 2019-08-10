package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

/**
 * https://leetcode.com/problems/alphabet-board-path/
 */
public class Problem1138 {
    public String alphabetBoardPath(String target) {
        char[][] board = new char[6][];
        board[0] = new char[]{'a', 'b', 'c', 'd', 'e'};
        board[1] = new char[]{'f', 'g', 'h', 'i', 'j'};
        board[2] = new char[]{'k', 'l', 'm', 'n', 'o'};
        board[3] = new char[]{'p', 'q', 'r', 's', 't'};
        board[4] = new char[]{'u', 'v', 'w', 'x', 'y'};
        board[5] = new char[]{'z'};
        int index = 0;
        alphabetBoardPath(board, target.charAt(index++), 6, 5, 0, 0);
        return null;
    }

    private static void alphabetBoardPath(char[][] board, char target, int maxRow, int maxCol,
                                          int row, int col) {
        Map<RowCol, RowCol> edgeTo = new HashMap<>();
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<RowCol> queue = new LinkedList<>();
        queue.add(new RowCol(row, col, ' '));
        while (!queue.isEmpty()) {
            RowCol current = queue.remove();
            if (visited[current.row][current.col]) {
                continue;
            }
            if (board[current.row][current.col] == target) {
//                System.out.println(edgeTo);
                RowCol rc = edgeTo.get(new RowCol(current.row, current.col, '!'));
                while (rc != null) {
                    System.out.println(rc + " --> " + board[rc.row][rc.col] + ": " + rc.direction);
                    rc = edgeTo.get(rc);
                }
                break;
            }
            visited[current.row][current.col] = true;
            for (int[] adjacent : new int[][]{{-1, 0, 'U'}, {0, 1, 'R'}, {1, 0, 'D'}, {0, -1, 'L'}}) {
                int r = current.row - adjacent[0];
                int c = current.col - adjacent[1];
                char d = (char) adjacent[2];
                System.out.println(d);
                if (r < 0 || r == maxRow || c < 0 || c == maxCol) {
                    continue;
                }
                if (visited[r][c]) {
                    continue;
                }
                RowCol rc = new RowCol(r, c, d);
                queue.add(rc);
                edgeTo.put(rc, current);
            }
        }

    }

    private static class RowCol {
        private final int row;
        private final int col;
        private final char direction;

        public RowCol(int row, int col, char direction) {
            this.row = row;
            this.col = col;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RowCol rowCol = (RowCol) o;
            return row == rowCol.row &&
                col == rowCol.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "[" + row  + ", " + col + "]";
        }
    }

    public static void main(String[] args) {
        Problem1138 prob = new Problem1138();
        System.out.println(prob.alphabetBoardPath("leet")); // "DDR!UURRR!!DDD!"
//        System.out.println(prob.alphabetBoardPath("code")); // "RR!DDRR!UUL!R!"
    }
}
