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

    public int[] findRightInterval(Interval[] intervals) {
        // TODO
        return new int[0];
    }

    public static void main(String[] args) {
        Problem436 prob = new Problem436();
        System.out.println(Arrays.toString(prob.findRightInterval(new Interval[]{new Interval(1, 2)}))); // [-1]
        System.out.println(Arrays.toString(prob.findRightInterval(new Interval[]{
            new Interval(3, 4),
            new Interval(2, 3),
            new Interval(1, 2)
        }))); // [-1, 0, 1]
        System.out.println(Arrays.toString(prob.findRightInterval(new Interval[]{
            new Interval(1, 4),
            new Interval(2, 3),
            new Interval(3, 4)
        }))); // [-1, 2, -1]
        System.out.println(Arrays.toString(prob.findRightInterval(new Interval[]{
            new Interval(4, 8),
            new Interval(3, 4),
            new Interval(1, 4)
        }))); // [-1, 0, 0]
        System.out.println(Arrays.toString(prob.findRightInterval(new Interval[]{
            new Interval(1, 2),
            new Interval(3, 5),
            new Interval(4, 5)
        }))); // [1, -1, -1]
    }
}
