package leetcode;

/**
 * https://leetcode.com/problems/map-sum-pairs/
 */
public class Problem677 {
    private static class MapSum {
        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            // TODO
        }

        public void insert(String key, int val) {
            // TODO
        }

        public int sum(String prefix) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap")); // 5
    }
}
