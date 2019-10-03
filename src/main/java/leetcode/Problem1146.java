package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array/
 */
public class Problem1146 {
    private static class SnapshotArray {
        private final int length;
        private int snapshot;
        private final Map</*snapshot ID*/ Integer, int[]> snapshots = new HashMap<>();

        public SnapshotArray(int length) {
            this.length = length;
        }

        public void set(int index, int val) {
            if (!snapshots.containsKey(snapshot)) {
                snapshots.put(snapshot, new int[length]);
            }
            snapshots.get(snapshot)[index] = val;
        }

        public int snap() {
            return snapshot++;
        }

        public int get(int index, int snap_id) {
            if (!snapshots.containsKey(snap_id)) {
                return 0;
            }
            return snapshots.get(snap_id)[index];
        }
    }

    public static void main(String[] args) {
        SnapshotArray sa = new SnapshotArray(3);
//        sa.set(0, 5);
//        System.out.println(sa.snap()); // 0
//        sa.set(0, 6);
//        System.out.println(sa.get(0, 0)); // 5

        sa = new SnapshotArray(1);
        sa.set(0, 15);
        System.out.println(sa.snap()); // 0
        System.out.println(sa.snap()); // 1
        System.out.println(sa.snap()); // 2
        System.out.println(sa.get(0, 2)); // 15
        System.out.println(sa.snap()); // 3
        System.out.println(sa.snap()); // 4
        System.out.println(sa.get(0, 0)); // 15
    }
}
