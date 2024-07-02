package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/print-immutable-linked-list-in-reverse/
public class Problem1265 {
    interface ImmutableListNode {
        void printValue(); // print the value of this node.
        ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        Stack<ImmutableListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.getNext();
        }
        while (!stack.isEmpty()) {
            stack.pop().printValue();
        }
    }
}
