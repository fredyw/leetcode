package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-circular-deque/
 */
public class Problem641 {
    private static class MyCircularDeque {
        private final int size;
        private final LinkedList<Integer> deque = new LinkedList<>();

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            size = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            deque.addFirst(value);
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            deque.addLast(value);
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            deque.removeFirst();
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            deque.removeLast();
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return deque.getFirst();
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return deque.getLast();
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return deque.isEmpty();
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return deque.size() == size;
        }
    }
}
