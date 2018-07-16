package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-circular-queue/
 */
public class Problem622 {
    private static class MyCircularQueue {
        private final int size;
        private final LinkedList<Integer> queue = new LinkedList<>();

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            size = k;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue.add(value);
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            queue.remove();
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue.getFirst();
        }

        /** Get the last item from the queue. */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            return queue.getLast();
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return queue.isEmpty();
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return queue.size() == size;
        }
    }
}
