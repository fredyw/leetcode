package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class Problem56 {
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

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a.start, b.start);
            if (cmp == 0) {
                return Integer.compare(a.end, b.end);
            }
            return cmp;
        });
        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = null;
            if (result.isEmpty()) {
                prev = intervals.get(i - 1);
            } else {
                prev = result.get(result.size() - 1);
            }
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start) {
                Interval newInterval = new Interval(prev.start, Math.max(curr.end, prev.end));
                result.set(result.size() - 1, newInterval);
            } else {
                result.add(curr);
            }
        }
        return result;
    }
}
