package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class Problem51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem51 prob = new Problem51();
        List<List<String>> result = prob.solveNQueens(4);
        for (List<String> row : result) {
            System.out.println(row);
        }
    }
}
