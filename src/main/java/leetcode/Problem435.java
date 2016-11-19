package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 */
public class Problem435 {
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

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a.start, b.start);
            if (cmp == 0) {
                return Integer.compare(a.start, b.start);
            }
            return cmp;
        });
        int result = 0;
        int i = 0;
        int j = i + 1;
        while (i < intervals.length && j < intervals.length) {
            Interval a = intervals[i];
            Interval b = intervals[j];
            if (b.start < a.end) {
                if (a.end < b.end) {
                    j++;
                } else {
                    i = j;
                    j++;
                }
                result++;
            } else {
                i = j;
                j++;
            }
        }
        return result;
    }
}
