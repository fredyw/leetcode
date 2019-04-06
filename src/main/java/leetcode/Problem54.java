package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class Problem54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int left = 0;
        int right = matrix.length > 0 ? matrix[0].length - 1 : 0;
        int up = 0;
        int down = matrix.length - 1;
        int dirIdx = 0;
        Direction[] directions = new Direction[]{
            Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP
        };
        while (left <= right && up <= down) {
            Direction direction = directions[dirIdx];
            switch (direction) {
                case RIGHT:
                    for (int col = left; col <= right; col++) {
                       answer.add(matrix[up][col]);
                    }
                    up++;
                    break;
                case DOWN:
                    for (int row = up; row <= down; row++) {
                        answer.add(matrix[row][right]);
                    }
                    right--;
                    break;
                case LEFT:
                    for (int col = right; col >= left; col--) {
                        answer.add(matrix[down][col]);
                    }
                    down--;
                    break;
                case UP:
                    for (int row = down; row >= up; row--) {
                        answer.add(matrix[row][left]);
                    }
                    left++;
                    break;
            }
            dirIdx++;
            dirIdx %= directions.length;
        }
        return answer;
    }

    private enum Direction {
        RIGHT, DOWN, LEFT, UP
    }
}
