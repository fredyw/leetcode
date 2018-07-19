package leetcode;

/**
 * https://leetcode.com/problems/design-hashmap/
 */
public class Problem706 {
    private static class MyHashMap {
        private final Integer[] map = new Integer[1000001];

        /** Initialize your data structure here. */
        public MyHashMap() {
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            map[key] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or
         * -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if (map[key] == null) {
                return -1;
            }
            return map[key];
        }

        /**
         * Removes the mapping of the specified value key if this map contains
         * a mapping for the key
         */
        public void remove(int key) {
            if (map[key] != null) {
                map[key] = null;
            }
        }
    }
}
