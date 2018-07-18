package leetcode;

/**
 * https://leetcode.com/problems/design-hashmap/
 */
public class Problem706 {
    private static class MyHashMap {

        /** Initialize your data structure here. */
        public MyHashMap() {
            // TODO
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            // TODO
        }

        /**
         * Returns the value to which the specified key is mapped, or
         * -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            // TODO
            return 0;
        }

        /**
         * Removes the mapping of the specified value key if this map contains
         * a mapping for the key
         */
        public void remove(int key) {
            // TODO
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1)); // returns 1
        System.out.println(hashMap.get(3)); // returns -1 (not found)
        hashMap.put(2, 1); // update the existing value
        System.out.println(hashMap.get(2)); // returns 1
        hashMap.remove(2); // remove the mapping for 2
        System.out.println(hashMap.get(2)); // returns -1 (not found)
    }
}
