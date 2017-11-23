package leetcode;

/**
 * https://leetcode.com/problems/my-calendar-ii/
 */
public class Problem731 {
    private static class MyCalendarTwo {

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo calendar = new MyCalendarTwo();
        System.out.println(calendar.book(10, 20)); // true
        System.out.println(calendar.book(50, 60)); // true
        System.out.println(calendar.book(10, 40)); // true
        System.out.println(calendar.book(5, 15)); // false
        System.out.println(calendar.book(5, 10)); // true
        System.out.println(calendar.book(25, 55)); // true
    }
}
