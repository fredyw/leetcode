package leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 */
public class Problem295 {
    static class MedianFinder {
        private final PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        private final PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> {
            return a.compareTo(b);
        });

        // Adds a number into the data structure.
        public void addNum(int num) {
            Integer max = maxQueue.peek();
            Integer min = minQueue.peek();
            if (minQueue.size() == maxQueue.size()) {
                if (max != null && num < max) {
                    Integer a = maxQueue.poll();
                    minQueue.add(a);
                    maxQueue.add(num);
                } else {
                    minQueue.add(num);
                }
            } else {
                if (num <= min) {
                    maxQueue.add(num);
                } else {
                    Integer a = minQueue.poll();
                    maxQueue.add(a);
                    minQueue.add(num);
                }
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (maxQueue.size() == minQueue.size()) {
                int max = maxQueue.peek();
                int min = minQueue.peek();
                return (max + min) / 2.0;
            }
            return minQueue.peek();
        }
    }
}
