package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 */
public class Problem352 {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static class SummaryRanges {
        private final HashMap<Integer, Interval> hashMap = new HashMap<>();
        private final TreeMap<Integer, Interval> treeMap = new TreeMap<>((a, b) -> Integer.compare(a, b));

        /** Initialize your data structure here. */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            if (hashMap.containsKey(val)) {
                return;
            }
            Map.Entry<Integer, Interval> lowerEntry = treeMap.lowerEntry(val);
            if (lowerEntry != null) {
                if (val < lowerEntry.getValue().end) {
                    return;
                }
            }

            int left = val - 1;
            int right = val + 1;
            if (hashMap.containsKey(left) && hashMap.containsKey(right)) {
                Interval leftInterval = hashMap.get(left);
                Interval rightInterval = hashMap.get(right);
                Interval newInterval = new Interval(leftInterval.start, rightInterval.end);

                hashMap.put(newInterval.start, newInterval);
                if (leftInterval.start != leftInterval.end) {
                    hashMap.remove(leftInterval.end);
                }

                hashMap.put(newInterval.end, newInterval);
                if (rightInterval.start != rightInterval.end) {
                    hashMap.remove(rightInterval.start);
                }

                treeMap.put(newInterval.start, newInterval);
                treeMap.remove(rightInterval.start);
            } else if (hashMap.containsKey(left)) {
                Interval leftInterval = hashMap.get(left);

                Interval newInterval = new Interval(leftInterval.start, val);

                hashMap.put(newInterval.start, newInterval);
                hashMap.put(newInterval.end, newInterval);
                if (leftInterval.start != leftInterval.end) {
                    hashMap.remove(leftInterval.end);
                }

                treeMap.put(newInterval.start, newInterval);
            } else if (hashMap.containsKey(right)) {
                Interval rightInterval = hashMap.get(right);

                Interval newInterval = new Interval(val, rightInterval.end);

                hashMap.put(newInterval.start, newInterval);
                hashMap.put(newInterval.end, newInterval);
                if (rightInterval.start != rightInterval.end) {
                    hashMap.remove(rightInterval.start);
                }

                treeMap.put(newInterval.start, newInterval);
                treeMap.remove(rightInterval.start);
            } else {
                Interval newInterval = new Interval(val, val);

                hashMap.put(val, newInterval);
                treeMap.put(val, newInterval);
            }
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(treeMap.values());
        }
    }
}
