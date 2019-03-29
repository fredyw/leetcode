package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
public class Problem460 {
    static class LFUCache {
        private final Map<Integer /*key*/, Integer /*value*/> keyValues = new HashMap<>();
        private final Map<Integer /*key*/, Integer /*count*/> keyCounts = new HashMap<>();
        private final Map<Integer /*count*/, LinkedHashSet<Integer> /*keys*/> countKeys = new HashMap<>();
        private final int capacity;
        private int minCount = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (capacity == 0 || !keyValues.containsKey(key)) {
                return -1;
            }
            int oldCount = keyCounts.get(key);
            int newCount = oldCount + 1;

            // Remove the old count for the given key.
            keyCounts.remove(key);
            // Update the new count for the given key.
            keyCounts.put(key, newCount);

            // Remove the key from the old counts.
            LinkedHashSet<Integer> keys = countKeys.get(oldCount);
            keys.remove(key);
            if (keys.isEmpty()) {
                countKeys.remove(oldCount);
                // If the old count is no longer the min count, we go to the next min count.
                if (minCount == oldCount) {
                    minCount++;
                }
            }
            // Add a new key into the new counts.
            countKeys.putIfAbsent(newCount, new LinkedHashSet<>());
            countKeys.get(newCount).add(key);

            return keyValues.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (keyValues.containsKey(key)) {
                // Overwrite the old value.
                keyValues.put(key, value);
                get(key);
                return;
            }
            if (keyValues.size() == capacity) {
                // Evict.
                LinkedHashSet<Integer> keys = countKeys.get(minCount);
                int evictedKey = keys.iterator().next();
                keys.remove(evictedKey);
                if (keys.isEmpty()) {
                    countKeys.remove(minCount);
                }
                keyCounts.remove(evictedKey);
                keyValues.remove(evictedKey);
            }
            int count = 1; // initial count
            keyValues.put(key, value);
            keyCounts.put(key, count);
            countKeys.putIfAbsent(count, new LinkedHashSet<>());
            countKeys.get(count).add(key);
            minCount = count;
        }
    }
}
