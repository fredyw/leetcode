package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class Problem56 {
    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> answer = new ArrayList<>();
        if (intervals.size() == 0) {
            return answer;
        }
        Collections.sort(intervals,
            Comparator.comparingInt((Interval a) -> a.start).thenComparingInt(a -> a.end));
        int i = 0;
        answer.add(intervals.get(i++));
        while (i < intervals.size()) {
            Interval lastAnswer = answer.get(answer.size() - 1);
            if (lastAnswer.end < intervals.get(i).start) { // no overlap
                answer.add(intervals.get(i));
            } else {
                int minStart = Integer.min(lastAnswer.start, intervals.get(i).start);
                int maxEnd = Integer.max(lastAnswer.end, intervals.get(i).end);
                answer.set(answer.size() - 1, new Interval(minStart, maxEnd));
            }
            i++;
        }
        return answer;
    }
}
