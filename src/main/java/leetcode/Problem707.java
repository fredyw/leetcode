package leetcode;

/**
 * https://leetcode.com/problems/design-linked-list/
 */
public class Problem707 {
    private static class MyLinkedList {
        private final static class Node {
            private final int value;
            private Node next;

            public Node(int value) {
                this.value = value;
            }
        }

        private Node head;
        private Node tail;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid,
         * return -1.
         */
        public int get(int index) {
            int idx = 0;
            for (Node n = head; n != null; n = n.next) {
                if (idx++ == index) {
                    return n.value;
                }
            }
            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            if (head == null) {
                head = new Node(val);
                tail = head;
            } else {
                Node tmp = head;
                head = new Node(val);
                head.next = tmp;
            }
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            if (tail == null) {
                tail = new Node(val);
                head = tail;
            } else {
                tail.next = new Node(val);
                tail = tail.next;
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended
         * to the end of linked list. If index is greater than the length, the node
         * will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index == 0) {
                addAtHead(val);
                return;
            }
            if (size == index) {
                addAtTail(val);
                return;
            }
            int idx = 0;
            for (Node n = head; n != null; n = n.next) {
                if (idx == index - 1) {
                    Node tmp = n.next;
                    n.next = new Node(val);
                    n.next.next = tmp;
                    size++;
                    break;
                }
                idx++;
            }
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (size == 0 || index >= size) {
                return;
            }
            if (index == 0) {
                head = head.next;
                size--;
                if (size == 0) {
                    tail = null;
                }
                return;
            }
            int idx = 0;
            for (Node n = head; n != null; n = n .next) {
                if (idx++ == index - 1) {
                    if (n.next == tail) {
                        tail = n;
                    }
                    n.next = n.next.next;
                    size--;
                    break;
                }
            }
        }
    }
}
