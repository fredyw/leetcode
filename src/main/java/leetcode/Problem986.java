package leetcode;

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

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem986 prob = new Problem986();
        System.out.println(prob.intervalIntersection(
            new Interval[]{
                new Interval(0, 2), new Interval(5, 10), new Interval(13, 23), new Interval(24, 25)
            }, new Interval[]{
                new Interval(1, 5), new Interval(8, 12), new Interval(15, 24), new Interval(25, 26)
            })); // [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
    }
}
