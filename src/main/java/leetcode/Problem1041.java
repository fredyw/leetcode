package leetcode;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class Problem1041 {
    public boolean isRobotBounded(String instructions) {
        Coord coord = new Coord();
        // try at least 4 times to make see if we can go back to the original position
        for (int i = 0; i < 4; i++) {
            for (char c : instructions.toCharArray()) {
                isRobotBounded(coord, c);
            }
        }
        return coord.x == 0 && coord.y == 0;
    }

    private static class Coord {
        private int x = 0;
        private int y = 0;
        private Direction direction = Direction.UP;
    }

    private static void isRobotBounded(Coord coord, char c) {
        if (c == 'G') {
            switch (coord.direction) {
                case UP:
                    coord.y++;
                    break;
                case RIGHT:
                    coord.x++;
                    break;
                case DOWN:
                    coord.y--;
                    break;
                case LEFT:
                    coord.x--;
                    break;
            }
        } else if (c == 'L') {
            switch (coord.direction) {
                case UP:
                    coord.direction = Direction.LEFT;
                    break;
                case RIGHT:
                    coord.direction = Direction.UP;
                    break;
                case DOWN:
                    coord.direction = Direction.RIGHT;
                    break;
                case LEFT:
                    coord.direction = Direction.DOWN;
                    break;
            }
        } else { // c == 'R'
            switch (coord.direction) {
                case UP:
                    coord.direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    coord.direction = Direction.DOWN;
                    break;
                case DOWN:
                    coord.direction = Direction.LEFT;
                    break;
                case LEFT:
                    coord.direction = Direction.UP;
                    break;
            }
        }
    }

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}
