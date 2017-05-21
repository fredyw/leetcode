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
        // TODO
        return result;
    }

    public static void main(String[] args) {
        Problem57 prob = new Problem57();
        System.out.println(prob.insert(Arrays.asList(
            new Interval(1, 3),
            new Interval(6, 9)),
            new Interval(2, 5))); // [1,5],[6,9]
        System.out.println(prob.insert(Arrays.asList(
            new Interval(1, 2),
            new Interval(3, 5),
            new Interval(6, 7),
            new Interval(8, 10),
            new Interval(12, 16)),
            new Interval(4, 9))); // [1,2],[3,10],[12,16]
    }
}
