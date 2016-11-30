package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/random-pick-index/
 */
public class Problem398 {
    public static class Solution {
        private final Map<Integer, List<Integer>> map = new HashMap<>();
        private final Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indices = map.get(target);
            int idx = random.nextInt(indices.size());
            return indices.get(idx);
        }
    }
}
