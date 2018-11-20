package leetcode;

import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class Problem528 {
    public static class Solution {
        private final Random random = new Random();
        private int sum;

        public Solution(int[] w) {
            for (int i : w) {
                sum += i;
            }
        }

        public int pickIndex() {
            int index = random.nextInt(sum);
            return 0;
        }
    }

    public static void main(String[] args) {
    }
}
