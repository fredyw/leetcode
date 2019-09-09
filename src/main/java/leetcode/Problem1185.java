package leetcode;

/**
 * https://leetcode.com/problems/day-of-the-week/
 */
public class Problem1185 {
    public String dayOfTheWeek(int day, int month, int year) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1185 prob = new Problem1185();
        System.out.println(prob.dayOfTheWeek(31, 8, 2019)); // "Saturday"
        System.out.println(prob.dayOfTheWeek(18, 7, 1999)); // "Sunday"
        System.out.println(prob.dayOfTheWeek(15, 8, 1993)); // "Sunday"
    }
}
