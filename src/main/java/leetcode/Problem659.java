package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/split-array-into-consecutive-subsequences/
 */
public class Problem659 {
    public boolean isPossible(int[] nums) {
        List<PriorityQueue<Integer>> listQueue = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean newQueue = true;
            for (PriorityQueue<Integer> queue : listQueue) {
                if (queue.peek() < nums[i]) {
                    newQueue = false;
                    queue.add(nums[i]);
                    break;
                }
            }
            if (newQueue) {
                PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
                queue.add(nums[i]);
                listQueue.add(queue);
            }
        }
        for (PriorityQueue<Integer> queue : listQueue) {
            if (queue.size() < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem659 prob = new Problem659();
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5})); // true
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 4, 4, 5})); // false
        System.out.println(prob.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 6})); // true
        System.out.println(prob.isPossible(new int[]{1, 3, 5})); // false
    }
}
