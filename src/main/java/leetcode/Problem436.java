package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-right-interval/
 */
public class Problem436 {
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

    private static class IntervalWrapper {
        private final int idx;
        private final Interval interval;

        public IntervalWrapper(int idx, Interval interval) {
            this.idx = idx;
            this.interval = interval;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        IntervalWrapper[] iws = new IntervalWrapper[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            iws[i] = new IntervalWrapper(i, intervals[i]);
        }
        Arrays.sort(iws, (a, b) -> Integer.compare(a.interval.start, b.interval.start));
        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = search(iws, intervals[i].end);
        }
        return result;
    }

    private static int search(IntervalWrapper[] iws, int val) {
        int lo = 0;
        int hi = iws.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (iws[mid].interval.start == val) {
                return iws[mid].idx;
            } else if (iws[mid].interval.start > val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo >= iws.length || hi < 0) {
            return -1;
        }
        return iws[lo].idx;
    }
}
