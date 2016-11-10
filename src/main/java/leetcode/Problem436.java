package leetcode;

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

    public int[] findRightInterval(Interval[] intervals) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem436 prob = new Problem436();
        System.out.println(prob.findRightInterval(new Interval[]{new Interval(1, 2)}));
        System.out.println(prob.findRightInterval(new Interval[]{
            new Interval(3, 4),
            new Interval(2, 3),
            new Interval(1, 2)
        }));
        System.out.println(prob.findRightInterval(new Interval[]{
            new Interval(1, 4),
            new Interval(2, 3),
            new Interval(3, 4)
        }));
    }
}
