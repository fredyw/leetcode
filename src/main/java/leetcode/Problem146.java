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

        private Node getNode(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                Node nodePrev = node.previous;
                Node nodeNext = node.next;
                if (nodeNext != null) {
                    node.previous = null;
                    node.next = null;
                    if (nodePrev == null) {
                        head = nodeNext;
                        nodeNext.previous = null;
                    } else {
                        nodePrev.next = nodeNext;
                        nodeNext.previous = nodePrev;
                    }
                    node.previous = tail;
                    tail.next = node;
                    tail = tail.next;
                }
                return node;
            }
            return null;
        }

        public void set(int key, int value) {
            Node node = getNode(key);
            if (node == null) {
                if (map.size() == capacity) {
                    if (head != null) {
                        map.remove(head.key);
                        Node tmp = head.next;
                        head = tmp;
                        if (head != null) {
                            head.previous = null;
                        }
                    }
                }
                node = new Node(key, value);
                if (head == null) {
                    head = node;
                }
                if (tail == null) {
                    tail = node;
                } else {
                    tail.next = node;
                    node.previous = tail;
                    tail = node;
                }
            } else {
                node.value = value;
            }
            map.put(key, node);
        }
    }
}
