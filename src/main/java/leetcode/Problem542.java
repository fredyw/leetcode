package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Problem542 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int maxRow = matrix.size();
        int maxCol = 0;
        if (matrix.size() > 0) {
            maxCol = matrix.get(0).size();
        }
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < maxRow; i++) {
            result.add(new ArrayList<>());
            for (int j = 0; j < maxCol; j++) {
                if (matrix.get(i).get(j) == 0) {
                    result.get(i).add(j);
                } else {
                    result.get(i).add(min(matrix, new boolean[maxRow][maxCol], maxRow, maxCol, i, j));
                }
            }
        }
//        System.out.println(min(matrix, new boolean[maxRow][maxCol], maxRow, maxCol, 2, 1));
//        System.out.println(min(matrix, new boolean[maxRow][maxCol], maxRow, maxCol, 1, 1));
        return result;
    }

    private static int min(List<List<Integer>> matrix, boolean[][] visited, int maxRow, int maxCol, int row, int col) {
        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol) {
            return 0;
        }
        if (matrix.get(row).get(col) == 0) {
            return 0;
        }
        if (visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int min = Integer.MAX_VALUE;
        // up
        int a = min(matrix, visited, maxRow, maxCol, row - 1, col);
        // right
        int b = min(matrix, visited, maxRow, maxCol, row, col + 1);
        // down
        int c = min(matrix, visited, maxRow, maxCol, row + 1, col);
        // left
        int d = min(matrix, visited, maxRow, maxCol, row, col - 1);
        if (a > 0) {
            min = Math.min(min, a);
        }
        if (b > 0) {
            min = Math.min(min, b);
        }
        if (c > 0) {
            min = Math.min(min, c);
        }
        if (d > 0) {
            min = Math.min(min, d);
        }
        if (min == Integer.MAX_VALUE) {
            return 1;
        }
        return min + 1;
    }

    private static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem542 prob = new Problem542();

//        // 0 0 0
//        // 0 1 0
//        // 0 0 0
//        print(prob.updateMatrix(Arrays.asList(
//            Arrays.asList(0, 0, 0),
//            Arrays.asList(0, 1, 0),
//            Arrays.asList(0, 0, 0)
//        )));
//
//        // 0 0 0
//        // 0 1 0
//        // 1 2 1
//        print(prob.updateMatrix(Arrays.asList(
//            Arrays.asList(0, 0, 0),
//            Arrays.asList(0, 1, 0),
//            Arrays.asList(1, 1, 1)
//        )));
//
//        // 0 0 0
//        // 1 1 1
//        // 2 2 2
//        print(prob.updateMatrix(Arrays.asList(
//            Arrays.asList(0, 0, 0),
//            Arrays.asList(1, 1, 1),
//            Arrays.asList(1, 1, 1)
//        )));

        // 0 1 0
        // 1 2 1
        // 2 3 2
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 1, 0),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1, 1, 1)
        )));
    }
}
