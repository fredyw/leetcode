package leetcode;

/**
 * https://leetcode.com/problems/design-circular-deque/
 */
public class Problem641 {
    private static class MyCircularDeque {

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            // TODO
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            // TODO
            return false;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            // TODO
            return false;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            // TODO
            return false;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            // TODO
            return false;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            // TODO
            return 0;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            // TODO
            return 0;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            // TODO
            return false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1)); // return true
        System.out.println(deque.insertLast(2)); // return true
        System.out.println(deque.insertFront(3)); // return true
        System.out.println(deque.insertFront(4)); // return false, the queue is full
        System.out.println(deque.getRear()); // return 32
        System.out.println(deque.isFull()); // return true
        System.out.println(deque.deleteLast()); // return true
        System.out.println(deque.insertFront(4)); // return true
        System.out.println(deque.getFront()); // return 4
    }
}
