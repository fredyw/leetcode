package leetcode;

/**
 * https://leetcode.com/problems/design-linked-list/
 */
public class Problem707 {
    private static class MyLinkedList {

        /** Initialize your data structure here. */
        public MyLinkedList() {
            // TODO
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            // TODO
            return 0;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            // TODO
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            // TODO
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            // TODO
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            // TODO
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
        System.out.println(linkedList.get(1)); // returns 2
        linkedList.deleteAtIndex(1); // now the linked list is 1->3
        System.out.println(linkedList.get(1)); // returns 3
    }
}
