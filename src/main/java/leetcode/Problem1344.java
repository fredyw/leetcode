package leetcode;

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
public class Problem1344 {
    public double angleClock(int hour, int minutes) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1344 prob = new Problem1344();
        System.out.println(prob.angleClock(12, 30)); // 165
        System.out.println(prob.angleClock(3, 30)); // 75
        System.out.println(prob.angleClock(4, 50)); // 155
        System.out.println(prob.angleClock(12, 0)); // 0
    }
}
