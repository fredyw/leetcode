package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
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

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem56 prob = new Problem56();
        System.out.println(prob.merge(Arrays.asList(new Interval[]{
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        }))); // [1,6], [8,10], [15,18]
    }
}
