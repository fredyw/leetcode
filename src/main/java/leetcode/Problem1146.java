package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class Problem1146 {
    private static class SnapshotArray {
        private int snapshot;
        private final Map</*snapshot ID*/ Integer, Map<Integer, Integer>> snapshots = new HashMap<>();

        public SnapshotArray(int length) {
            snapshots.put(snapshot, new HashMap<>());
        }

        public void set(int index, int val) {
            snapshots.get(snapshot).put(index, val);
        }

        public int snap() {
            snapshots.put(snapshot + 1,
                new HashMap<>(snapshots.get(snapshot)));
            return snapshot++;
        }

        public int get(int index, int snap_id) {
            if (!snapshots.containsKey(snap_id)) {
                return 0;
            }
            return snapshots.get(snap_id).getOrDefault(index, 0);
        }
    }
}
