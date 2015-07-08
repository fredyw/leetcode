package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class Problem225 {
    static class MyStack {
        private Queue<Integer> list1 = new LinkedList<>();
        private Queue<Integer> list2 = new LinkedList<>();
            
        // Push element x onto stack.
        public void push(int x) {
            while (!list1.isEmpty()) {
                list2.add(list1.remove());
            }
            list1.add(x);
            while (!list2.isEmpty()) {
                list1.add(list2.remove());
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            list1.remove();
        }

        // Get the top element.
        public int top() {
            return list1.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return list1.isEmpty();
        }
    }
}
