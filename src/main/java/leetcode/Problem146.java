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

        // 1 (tail) <-> 2 <-> 3 (node) <-> 4 <-> 5 (head)
        // get(3)
        // 1 (tail) <-> 2 <-> 4 <-> 5 <-> 3 (head)
        private Node getNode(int key) {
            if (!map.containsKey(key)) {
                return null;
            }
            Node node = map.get(key);
            if (node.previous != null) {
                node.previous.next = node.next;
            } else { // node.previous == tail
                if (tail.next != null) {
                    // there's no previous, we need to update the tail
                    tail = tail.next;
                    if (tail != null) {
                        tail.previous = null;
                    }
                }
            }
            if (node.next != null) {
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
                        if (tail != null) {
                            tail.previous = null; // to be a new tail, there should not be a previous
                        }
                    }
                }
                map.put(key, newNode);
            } else {
                node.value = value;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
//        lru.put(1, 1);
//        lru.put(2, 2);
//        System.out.println(lru.get(1)); // 1
//        lru.put(3, 3);
//        System.out.println(lru.get(2)); // -1
//        lru.put(4, 4);
//        System.out.println(lru.get(1)); // -1
//        System.out.println(lru.get(3)); // 3
//        System.out.println(lru.get(4)); // 4
//
//        lru = new LRUCache(1);
//        lru.put(2, 1);
//        System.out.println(lru.get(2)); // 1;
//        lru.put(3, 2);
//        System.out.println(lru.get(2)); // -1
//        System.out.println(lru.get(3)); // 2

        lru = new LRUCache(10);
        lru.put(10, 13);
        lru.put(3, 17);
        lru.put(6, 11);
        lru.put(10, 5);
        lru.put(9, 10);
        System.out.println(lru.get(13)); // -1
        lru.put(2, 19);
        System.out.println(lru.get(2)); // 19
        System.out.println(lru.get(3)); // 17
        lru.put(5, 25);
        System.out.println(lru.get(8)); // -1
        lru.put(9, 22);
        lru.put(5, 5);
        lru.put(1, 30);
        System.out.println(lru.get(11)); // -1
        lru.put(9, 12);
        System.out.println(lru.get(7)); // -1
        System.out.println(lru.get(5)); // 5
        System.out.println(lru.get(8)); // -1
        System.out.println(lru.get(9)); // 12
        lru.put(4, 30);
        lru.put(9, 3);
        System.out.println(lru.get(9));
        System.out.println(lru.get(10));
        System.out.println(lru.get(10));
        lru.put(6, 14);
        lru.put(3, 1);
        System.out.println(lru.get(3));
        lru.put(10, 11);
        System.out.println(lru.get(8));
        lru.put(2, 14);
        System.out.println(lru.get(1));
        System.out.println(lru.get(5));
        System.out.println(lru.get(4));
        lru.put(11, 4);
        System.out.println(lru.map + ": " + lru.tail);
        lru.put(12, 24);
        System.out.println(lru.map + ": " + lru.tail);
        lru.put(5, 18);
        System.out.println(lru.map + ": " + lru.tail);
        System.out.println(lru.get(13));
        lru.put(7, 23);
        System.out.println(lru.map + ": " + lru.tail);
    }
}
