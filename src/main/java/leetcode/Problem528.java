package leetcode;

import java.util.Random;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/random-pick-with-weight/
 */
public class Problem528 {
    public static class Solution {
        private final TreeMap<Integer, Integer> map = new TreeMap<>();
        private final Random random = new Random();
        private int sum;

        public Solution(int[] w) {
            // Example:
            // [1, 3, 5] -> [0, 1, 1, 1, 2, 2, 2, 2, 2]
            // map -> [0 -> 0, 1 -> 1, 4 -> 2]
            int index = 0;
            for (int i : w) {
                map.put(sum, index++);
                sum += i;
            }
            System.out.println(map.toString());
        }

        public int pickIndex() {
            return map.floorEntry(random.nextInt(sum)).getValue();
        }
    }
}
