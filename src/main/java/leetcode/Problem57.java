package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class Problem57 {
    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> answer = new ArrayList<>();
        if (intervals.size() == 0) {
            answer.add(newInterval);
            return answer;
        }
        boolean[] overlaps = new boolean[intervals.size()];
        boolean hasOverlap = false;
        for (int i = 0; i < intervals.size(); i++) {
            boolean a = intervals.get(i).start <= newInterval.start &&
                newInterval.start <= intervals.get(i).end;
            boolean b = intervals.get(i).start <= newInterval.end &&
                newInterval.start <= intervals.get(i).end;

            boolean c = newInterval.start <= intervals.get(i).start &&
                intervals.get(i).end <= newInterval.end;
            boolean d = newInterval.start <= intervals.get(i).end &&
                intervals.get(i).end <= newInterval.end;

            overlaps[i] = a || b || c || d;
            hasOverlap |= overlaps[i];
        }
        int i = 0;
        boolean added = false;
        while (i < intervals.size()) {
            if (!overlaps[i]) {
                if (!hasOverlap && !added) {
                    if (newInterval.end < intervals.get(i).start) {
                        answer.add(newInterval);
                        added = true;
                    }
                }
                answer.add(intervals.get(i));
                i++;
            } else {
                // Merge.
                int newStart = Integer.min(newInterval.start, intervals.get(i).start);
                int newEnd = 0;
                while (i < intervals.size() && overlaps[i]) {
                    newEnd = Integer.max(newInterval.end, intervals.get(i).end);
                    i++;
                }
                answer.add(new Interval(newStart, newEnd));
            }
        }
        if (!hasOverlap) {
            if (intervals.get(intervals.size() - 1).end < newInterval.start) {
                answer.add(newInterval);
            }
        }
        return answer;
    }
}
