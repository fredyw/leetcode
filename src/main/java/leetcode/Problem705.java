package leetcode;

/**
 * https://leetcode.com/problems/design-hashset/
 */
public class Problem705 {
    private static class MyHashSet {
        private final boolean[] set = new boolean[1000001];

        /** Initialize your data structure here. */
        public MyHashSet() {
        }

        public void add(int key) {
            set[key] = true;
        }

        public void remove(int key) {
            set[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return set[key];
        }
    }
}
