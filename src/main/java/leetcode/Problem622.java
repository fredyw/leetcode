package leetcode;

/**
 * https://leetcode.com/problems/design-circular-queue/
 */
public class Problem622 {
    private static class MyCircularQueue {

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            // TODO
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            // TODO
            return false;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            // TODO
            return false;
        }

        /** Get the front item from the queue. */
        public int Front() {
            // TODO
            return 0;
        }

        /** Get the last item from the queue. */
        public int Rear() {
            // TODO
            return 0;
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            // TODO
            return false;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
        circularQueue.enQueue(1);  // return true
        circularQueue.enQueue(2);  // return true
        circularQueue.enQueue(3);  // return true
        circularQueue.enQueue(4);  // return false, the queue is full
        circularQueue.Rear();  // return 3
        circularQueue.isFull();  // return true
        circularQueue.deQueue();  // return true
        circularQueue.enQueue(4);  // return true
        circularQueue.Rear();  // return 4
    }
}
