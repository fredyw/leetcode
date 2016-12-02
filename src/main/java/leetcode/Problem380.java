package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class Problem380 {
    private static class Value {
        private int idx;
        private final int val;

        public Value(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static class RandomizedSet {
        private final Map<Integer, Value> map = new HashMap<>();
        private final List<Value> list = new ArrayList<>();
        private final Random random = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int idx = list.size();
            Value value = new Value(idx, val);
            list.add(value);
            map.put(val, value);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            Value value = map.remove(val);
            int deletedIdx = value.idx;
            Value last = list.get(list.size() - 1);
            if (deletedIdx != last.idx) {
                last.idx = deletedIdx;
                list.set(deletedIdx, last);
            }
            list.remove(list.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(list.size());
            Value value = list.get(idx);
            return value.val;
        }
    }
}
