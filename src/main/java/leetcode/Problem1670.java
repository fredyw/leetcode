package leetcode;

/**
 * https://leetcode.com/problems/design-front-middle-back-queue/
 */
public class Problem1670 {
    static class FrontMiddleBackQueue {
        public FrontMiddleBackQueue() {
        }

        public void pushFront(int val) {
            // TODO
        }

        public void pushMiddle(int val) {
            // TODO
        }

        public void pushBack(int val) {
            // TODO
        }

        public int popFront() {
            // TODO
            return 0;
        }

        public int popMiddle() {
            // TODO
            return 0;
        }

        public int popBack() {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);  // [1]
        q.pushBack(2);   // [1, 2]
        q.pushMiddle(3); // [1, 3, 2]
        q.pushMiddle(4); // [1, 4, 3, 2]
        System.out.println(q.popFront());  // return 1 -> [4, 3, 2]
        System.out.println(q.popMiddle()); // return 3 -> [4, 2]
        System.out.println(q.popMiddle()); // return 4 -> [2]
        System.out.println(q.popBack());   // return 2 -> []
        System.out.println(q.popFront());  // return -1 -> [] (The queue is empty)
    }
}
