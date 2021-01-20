package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/design-front-middle-back-queue/
 */
public class Problem1670 {
    static class FrontMiddleBackQueue {
        private final LinkedList<Integer> front = new LinkedList<>();
        private final LinkedList<Integer> back = new LinkedList<>();

        public FrontMiddleBackQueue() {
        }

        public void pushFront(int val) {
            front.addFirst(val);
            rebalance(front, back);
        }

        public void pushMiddle(int val) {
            if (front.size() > back.size()) {
                back.addFirst(front.pollLast());
            }
            front.addLast(val);
        }

        public void pushBack(int val) {
            back.addLast(val);
            rebalance(front, back);
        }

        public int popFront() {
            if (front.isEmpty() && back.isEmpty()) {
                return -1;
            }
            if (front.isEmpty()) {
                return popBack();
            }
            int val = front.pollFirst();
            rebalance(front, back);
            return val;
        }

        public int popMiddle() {
            if (front.isEmpty() && back.isEmpty()) {
                return -1;
            }
            int val = front.pollLast();
            rebalance(front, back);
            return val;
        }

        public int popBack() {
            if (front.isEmpty() && back.isEmpty()) {
                return -1;
            }
            if (back.isEmpty()) {
                return popFront();
            }
            int val = back.pollLast();
            rebalance(front, back);
            return val;
        }

        private static void rebalance(LinkedList<Integer> front, LinkedList<Integer> back) {
            if (front.size() - 2 >= back.size()) {
                back.addFirst(front.pollLast());
            } else if (back.size() > front.size()) {
                front.addLast(back.pollFirst());
            }
        }
    }
}
