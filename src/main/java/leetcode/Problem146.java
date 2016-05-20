package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/
 */
public class Problem146 {
    public static class LRUCache {
        private final Map<Integer, Integer> map = new HashMap<>();
        private final LinkedList<Integer> list = new LinkedList<>();
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                list.addLast(key);
                list.removeFirst();
            }
            return map.getOrDefault(key, -1);
        }

        public void set(int key, int value) {
            if (!map.containsKey(key)) {
                list.addLast(key);
            }
            map.put(key, value);
            if (map.size() -1 == capacity) {
                int removedKey = list.removeFirst();
                map.remove(removedKey);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
//        lru.set(2, 1);
//        lru.set(1, 1);
//        System.out.println(lru.get(2)); // 1
//        lru.set(4, 1);
//        System.out.println(lru.get(1)); // -1
//        System.out.println(lru.get(2)); // 1
//        lru.set(5, 1);
//        lru.set(6, 1);
//        System.out.println(lru.get(1)); // -1
//        System.out.println(lru.get(2)); // -1
//        System.out.println(lru.get(3)); // -1
//        System.out.println(lru.get(4)); // -1
//        System.out.println(lru.get(5)); // 1
//        System.out.println(lru.get(6)); // 1

        lru.set(2, 1);
        System.out.println("1. " + lru.map);
        System.out.println("1. " + lru.list);
        lru.set(1, 1);
        System.out.println("2. " + lru.map);
        System.out.println("2. " + lru.list);
        lru.set(2, 3);
        System.out.println("3. " + lru.map);
        System.out.println("3. " + lru.list);
        lru.set(4, 1);
        System.out.println("4. " + lru.map);
        System.out.println("4. " + lru.list);
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(2)); // 3
        System.out.println("5. " + lru.map);
        System.out.println("5. " + lru.list);
    }
}
