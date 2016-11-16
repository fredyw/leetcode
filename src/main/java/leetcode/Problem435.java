package leetcode;

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
        // TODO
        return 0;
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
    }
}
