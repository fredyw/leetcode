package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class Problem146 {
    public static class LRUCache {
        private static class Node {
            private final int key;
            private int value;
            private Node previous;
            private Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                return "(" + key + "," + value + ")";
            }
        }

        private final Map<Integer, Node> map = new HashMap<>();
        private Node head;
        private Node tail;
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = getNode(key);
            if (node == null) {
                return -1;
            }
            return node.value;
        }

        // Case 1:
        // 1 (tail) <-> 2 <-> 3 <-> 4 <-> 5 (head)
        // get(5)
        // 1 (tail) <-> 2 <-> 3 <-> 4 <-> 5 (head)
        //
        // Case 2:
        // 1 (tail) <-> 2 <-> 3 <-> 4 <-> 5 (head)
        // get(3)
        // 1 (tail) <-> 2 <-> 4 <-> 5 <-> 3 (head)
        //
        // Case 3:
        // 1 (tail) <-> 2 <-> 3 <-> 4 <-> 5 (head)
        // get(1)
        // 2 (tail) <-> 3 <-> 4 <-> 5 <-> 1 (head)
        private Node getNode(int key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node node = map.get(key);
            // case 1
            if (head == node) {
                return node;
            }
            if (tail == node) { // case 3
                tail = tail.next;
                tail.previous = null;
            } else { // case 2
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
            // update the new head
            head.next = node;
            node.previous = head;
            head = node;
            head.next = null; // to be a new head, the should not be a next

            return node;
        }

        // 1 (tail) <-> 2 <-> 3 <-> 4 <-> 5 (head)
        // put(6, 6)
        // 2 (tail) <-> 3 <-> 4 <-> 5 <-> 6 (head)
        public void put(int key, int value) {
            Node node = getNode(key);
            if (node == null) {
                // update head
                Node newNode = new Node(key, value);
                if (head != null) {
                    head.next = newNode;
                    newNode.previous = head;
                }
                head = newNode;

                // update tail
                if (tail == null) {
                    tail = newNode;
                } else {
                    if (map.size() == capacity) {
                        map.remove(tail.key);
                        tail = tail.next;
                        tail.previous = null; // to be a new tail, there should not be a previous
                    }
                }
                map.put(key, newNode);
            } else {
                node.value = value;
            }
        }
    }
}
