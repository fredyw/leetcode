package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 */
public class Problem1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int[] queen : queens) {
            set.add(queen[0] + "," + queen[1]);
        }
        for (int[] queen : queens) {
            if (canAttack(queen, king, 8, 8, set)) {
                answer.add(Arrays.asList(queen[0], queen[1]));
            }
        }
        return answer;
    }

    private static boolean canAttack(int[] queen, int[] king, int maxRow, int maxCol, Set<String> queens) {
        // top
        for (int row = queen[0] - 1, col = queen[1]; row >= 0; row--) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // top right
        for (int row = queen[0] - 1, col = queen[1] + 1; row >= 0 && col < maxCol; row--, col++) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // right
        for (int row = queen[0], col = queen[1] + 1; col < maxCol; col++) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // bottom right
        for (int row = queen[0] + 1, col = queen[1] + 1; row < maxRow && col < maxCol; row++, col++) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // bottom
        for (int row = queen[0] + 1, col = queen[1]; row < maxRow; row++) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // bottom left
        for (int row = queen[0] + 1, col = queen[1] - 1; row < maxRow && col >= 0; row++, col--) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // left
        for (int row = queen[0], col = queen[1] - 1; col >= 0; col--) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        // top left
        for (int row = queen[0] - 1, col = queen[1] - 1; row >= 0 && col >= 0; row--, col--) {
            if (queens.contains(row + "," + col)) {
                break;
            }
            if (row == king[0] && col == king[1]) {
                return true;
            }
        }
        return false;
    }
}
