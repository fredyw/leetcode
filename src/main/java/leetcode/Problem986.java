package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 */
public class Problem986 {
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

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> answer = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if ((A[i].start <= B[j].start && B[j].start <= A[i].end) ||
                (B[j].start <= A[i].start && A[i].start <= B[j].end)) {
                int start = Integer.max(A[i].start, B[j].start);
                int end = Integer.min(A[i].end, B[j].end);
                if (A[i].end < B[j].end) {
                    i++;
                } else if (A[i].end == B[j].end) {
                    i++;
                    j++;
                } else {
                    j++;
                }
                answer.add(new Interval(start, end));
            } else if (A[i].start < B[j].start) {
                i++;
            } else if (B[j].start < A[i].start) {
                j++;
            }
        }
        return answer.toArray(new Interval[0]);
    }
}
