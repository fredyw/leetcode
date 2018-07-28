package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class Problem703 {
    private static class KthLargest {
        private final PriorityQueue<Integer> queue = new PriorityQueue<>();
        private final int k;

        public KthLargest(int k, int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                queue.add(nums[i]);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
            this.k = k;
        }

        public int add(int val) {
            queue.add(val);
            if (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
