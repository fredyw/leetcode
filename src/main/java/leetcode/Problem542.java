package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/01-matrix/
 */
public class Problem542 {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        // TODO
        return new ArrayList<>();
    }

    private static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println(matrix.get(i));
        }
    }

    public static void main(String[] args) {
        Problem542 prob = new Problem542();

        // 0 0 0
        // 0 1 0
        // 0 0 0
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(0, 0, 0)
        )));

        // 0 0 0
        // 0 1 0
        // 1 2 1
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(0, 1, 0),
            Arrays.asList(1, 1, 1)
        )));

        // 0 0 0
        // 1 1 1
        // 2 2 2
        print(prob.updateMatrix(Arrays.asList(
            Arrays.asList(0, 0, 0),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1, 1, 1)
        )));

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
