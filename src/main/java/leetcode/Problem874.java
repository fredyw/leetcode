package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/walking-robot-simulation/
 */
public class Problem874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        Set<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(key(obstacle[0], obstacle[1]));
        }
        int x = 0;
        int y = 0;
        Direction direction = Direction.UP;
        for (int cmd : commands) {
            if (cmd == -2 || cmd == -1) {
                direction = newDirection(direction, cmd);
            } else {
                for (int i = 0; i < cmd; i++) {
                    if (direction == Direction.UP) {
                        if (set.contains(key(x, y + 1))) {
                            break;
                        }
                        y++;
                    } else if (direction == Direction.LEFT) {
                        if (set.contains(key(x - 1, y))) {
                            break;
                        }
                        x--;
                    } else if (direction == Direction.DOWN) {
                        if (set.contains(key(x, y - 1))) {
                            break;
                        }
                        y--;
                    } else { // Direction.RIGHT
                        if (set.contains(key(x + 1, y))) {
                            break;
                        }
                        x++;
                    }
                }
                max = Math.max(max, (x * x) + (y * y));
            }
        }
        return max;
    }

    private enum Direction {
        LEFT, RIGHT, UP, DOWN
    }

    private static Direction newDirection(Direction current, int cmd) {
        if (current == Direction.UP) {
            return (cmd == -2) ? Direction.LEFT : Direction.RIGHT;
        } else if (current == Direction.LEFT) {
            return (cmd == -2) ? Direction.DOWN : Direction.UP;
        } else if (current == Direction.DOWN) {
            return (cmd == -2) ? Direction.RIGHT : Direction.LEFT;
        } else { // Direction.RIGHT
            return (cmd == -2) ? Direction.UP : Direction.DOWN;
        }
    }

    private static String key(int x, int y) {
        return x + "|" + y;
    }
}
