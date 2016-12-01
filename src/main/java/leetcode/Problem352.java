package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        private final Map<Integer, Interval> hashMap = new HashMap<>();
        private final Map<Integer, Interval> treeMap = new TreeMap<>((a, b) -> Integer.compare(a, b));

        /** Initialize your data structure here. */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            System.out.println("adding " + val);
            if (hashMap.containsKey(val)) {
                return;
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

    private static void print(List<Interval> intervals) {
        System.out.println(intervals.stream()
            .map(i -> "[" + i.start + "," + i.end + "]")
            .collect(Collectors.joining(", ")));
    }

    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();

//        sr.addNum(6);
//        print(sr.getIntervals());
//
//        sr.addNum(6);
//        print(sr.getIntervals());
//
//        sr.addNum(0);
//        print(sr.getIntervals());
//
//        sr.addNum(4);
//        print(sr.getIntervals());
//
//        sr.addNum(8);
//        print(sr.getIntervals());
//
//        sr.addNum(7);
//        print(sr.getIntervals());
//
//        sr.addNum(6);
//        print(sr.getIntervals());
//
//        sr.addNum(4);
//        print(sr.getIntervals());
//
//        sr.addNum(7);
//        print(sr.getIntervals());
//
//        sr.addNum(5);
//        print(sr.getIntervals());

//        sr.addNum(1);
//        print(sr.getIntervals());
//
//        sr.addNum(3);
//        print(sr.getIntervals());
//
//        sr.addNum(7);
//        print(sr.getIntervals());
//
//        sr.addNum(2);
//        print(sr.getIntervals());
//
//        sr.addNum(6);
//        print(sr.getIntervals());
//
//        sr.addNum(4);
//        print(sr.getIntervals());
//
//        sr.addNum(5);
//        print(sr.getIntervals());
    }
}
