package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class Problem57 {
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

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, (e1, e2) -> {
            int cmp = Integer.compare(e1.start, e2.start);
            if (cmp == 0) {
                return Integer.compare(e1.end, e2.end);
            }
            return cmp;
        });
        List<Interval> result = new ArrayList<>();
        int i = 0;
        for (; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end < intervals.get(i + 1).start) {
                result.add(intervals.get(i));
            } else { // overlap
                int start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                int end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                boolean add = false;
                for (; i < intervals.size(); i++) {
                    if (intervals.get(i).start <= end) {
                        end = Math.max(intervals.get(i).end, end);
                        add = true;
                    } else {
                        if (add) {
                            result.add(new Interval(start, end));
                            add = false;
                        }
                        result.add(intervals.get(i));
                    }
                }
                if (add) {
                    result.add(new Interval(start, end));
                }
            }
        }
        if (i < intervals.size()) {
            result.add(intervals.get(i));
        }
        return result;
    }

    private static List<Interval> createList(Interval... intervals) {
        List<Interval> list = new ArrayList<>();
        for (Interval interval : intervals) {
            list.add(interval);
        }
        return list;
    }

    public static void main(String[] args) {
        Problem57 prob = new Problem57();
//        System.out.println(prob.insert(createList(
//            new Interval(1, 3),
//            new Interval(6, 9)),
//            new Interval(2, 5))); // [1,5],[6,9]
//        System.out.println(prob.insert(createList(
//            new Interval(1, 2),
//            new Interval(3, 5),
//            new Interval(6, 7),
//            new Interval(8, 10),
//            new Interval(12, 16)),
//            new Interval(4, 9))); // [1,2],[3,10],[12,16]
//        System.out.println(prob.insert(createList(
//            new Interval(2, 3),
//            new Interval(5, 7)),
//            new Interval(1, 9))); // [1,9]
//        System.out.println(prob.insert(createList(
//            new Interval(2, 3),
//            new Interval(5, 7)),
//            new Interval(1, 6))); // [1,7]
//        System.out.println(prob.insert(createList(
//            new Interval(4, 5)),
//            new Interval(1, 2))); // [1,2],[4,5]
//        System.out.println(prob.insert(createList(
//            new Interval(1, 5)),
//            new Interval(2, 7))); // [1,7]
//        System.out.println(prob.insert(createList(),
//            new Interval(5, 7))); // [5,7]
//        System.out.println(prob.insert(createList(
//            new Interval(1, 5)),
//            new Interval(6, 8))); // [1,5],[6,8]
//        System.out.println(prob.insert(createList(
//            new Interval(1, 5)),
//            new Interval(2, 3))); // [1,5]
//        System.out.println(prob.insert(createList(
//            new Interval(1, 5)),
//            new Interval(5, 7))); // [1,7]
        System.out.println(prob.insert(createList(
            new Interval(1, 5),
            new Interval(6, 8)),
            new Interval(5, 6))); // [1,8]
    }
}
