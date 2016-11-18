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

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int cmp = Integer.compare(a.start, b.start);
            if (cmp == 0) {
                return Integer.compare(a.end, b.end);
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
                j++;
                result++;
            } else {
                i = j;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem435 prob = new Problem435();
        System.out.println(prob.eraseOverlapIntervals(new Interval[] {
            new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3)
        })); // 1
        System.out.println(prob.eraseOverlapIntervals(new Interval[] {
            new Interval(1, 2), new Interval(1, 2), new Interval(1, 2)
        })); // 2
        System.out.println(prob.eraseOverlapIntervals(new Interval[] {
            new Interval(1, 2), new Interval(2, 3)
        })); // 0
        System.out.println(prob.eraseOverlapIntervals(new Interval[] {
            new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3),
            new Interval(2, 5), new Interval(4, 5), new Interval(3, 5)
        })); // 3
        System.out.println(prob.eraseOverlapIntervals(new Interval[] {
            new Interval(0, 2), new Interval(1, 3), new Interval(2, 4), new Interval(3, 5),
            new Interval(4, 6)
        })); // 2
    }
}
