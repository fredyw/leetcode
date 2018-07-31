package leetcode;

import java.util.Random;

/**
 * https://leetcode.com/problems/implement-rand10-using-rand7/
 */
public class Problem470 {
    private final Random random = new Random(System.currentTimeMillis());

    public int rand7() {
        int min = 1;
        int max = 7;
        return random.nextInt(max - min + 1) + min;
    }

    public int rand10() {
        int row = rand7();
        int col = rand7();
        int index = col + ((row - 1) * 7);
        while (index > 40) {
            row = rand7();
            col = rand7();
            index = col + ((row - 1) * 7);
        }
        return 1 + (index - 1) % 10;
    }
}
