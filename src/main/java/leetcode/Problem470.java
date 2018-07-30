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
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem470 prob = new Problem470();
    }
}
