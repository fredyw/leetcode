package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sort-array-by-increasing-frequency/
 */
public class Problem1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] sorted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sorted[i] = nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Arrays.sort(sorted, (a, b) -> {
            int count1 = map.get(a);
            int count2 = map.get(b);
            if (count1 == count2) {
                return Integer.compare(b, a);
            }
            return Integer.compare(count1, count2);
        });
        int[] answer = new int[nums.length];
        for (int i = 0; i < sorted.length; i++) {
            answer[i] = sorted[i];
        }
        return answer;
    }
}
