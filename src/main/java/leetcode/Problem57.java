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
}
