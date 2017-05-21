package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }
        boolean addNewInterval = true;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start <= newInterval.start && newInterval.start <= interval.end &&
                newInterval.end > interval.end) {
                for (int j = i; j < intervals.size(); j++) {
                    if (intervals.get(j).start > newInterval.end) {
                        addNewInterval = false;
                        result.add(new Interval(interval.start, newInterval.end));
                        break;
                    }
                    if (newInterval.end <= intervals.get(j).end) {
                        addNewInterval = false;
                        result.add(new Interval(interval.start, intervals.get(j).end));
                        i = j;
                        break;
                    }
                }
                if (result.isEmpty()) {
                    addNewInterval = false;
                    result.add(new Interval(interval.start, newInterval.end));
                }
            } else if (newInterval.end < interval.start) {
                if (addNewInterval) {
                    addNewInterval = false;
                    result.add(newInterval);
                }
                result.add(interval);
            } else if (newInterval.start < interval.start) {
                for (int j = i; j < intervals.size(); j++) {
                    if (newInterval.end <= intervals.get(j).end) {
                        addNewInterval = false;
                        result.add(new Interval(newInterval.start, intervals.get(j).end));
                        i = j;
                        break;
                    }
                }
                if (result.isEmpty()) {
                    addNewInterval = false;
                    result.add(newInterval);
                }
            } else {
                result.add(interval);
            }
        }
        if (addNewInterval) {
            result.add(newInterval);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem57 prob = new Problem57();
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(1, 3),
//            new Interval(6, 9)),
//            new Interval(2, 5))); // [1,5],[6,9]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(1, 2),
//            new Interval(3, 5),
//            new Interval(6, 7),
//            new Interval(8, 10),
//            new Interval(12, 16)),
//            new Interval(4, 9))); // [1,2],[3,10],[12,16]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(2, 3),
//            new Interval(5, 7)),
//            new Interval(1, 9))); // [1,9]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(2, 3),
//            new Interval(5, 7)),
//            new Interval(1, 6))); // [1,7]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(4, 5)),
//            new Interval(1, 2))); // [1,2],[4,5]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(1, 5)),
//            new Interval(2, 7))); // [1,7]
//        System.out.println(prob.insert(Arrays.asList(),
//            new Interval(5, 7))); // [5,7]
//        System.out.println(prob.insert(Arrays.asList(
//            new Interval(1, 5)),
//            new Interval(6, 8))); // [1,5],[6,8]
        System.out.println(prob.insert(Arrays.asList(
            new Interval(1, 5)),
            new Interval(2, 3))); // [1,5]
    }
}
