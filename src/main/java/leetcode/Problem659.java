package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class Problem659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            PriorityQueue<Integer> previous = map.get(nums[i] - 1);
            PriorityQueue<Integer> current = map.get(nums[i]);
            if (previous == null) {
                if (map.containsKey(nums[i])) {
                    PriorityQueue<Integer> q = current;
                    q.add(1);
                    map.put(nums[i], q);
                } else {
                    PriorityQueue<Integer> newQueue = new PriorityQueue<>();
                    newQueue.add(1);
                    map.put(nums[i], newQueue);
                }
            } else {
                Integer count = previous.remove();
                if (current != null) {
                    current.add(count + 1);
                } else {
                    PriorityQueue<Integer> newQueue = new PriorityQueue<>();
                    newQueue.add(count + 1);
                    map.put(nums[i], newQueue);
                }
                if (previous.isEmpty()) {
                    map.remove(nums[i] - 1);
                }
            }
        }
        for (PriorityQueue<Integer> count : map.values()) {
            for (int c : count) {
                if (c < 3) {
                    return false;
                }
            }
        }
        return true;
    }
}
