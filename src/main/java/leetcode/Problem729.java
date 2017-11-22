package leetcode;

/**
 * https://leetcode.com/problems/my-calendar-i/
 */
public class Problem729 {
    private static class MyCalendar {

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            // TODO
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        calendar.book(10, 20); // returns true
        calendar.book(15, 25); // returns false
        calendar.book(20, 30); // returns true
    }
}
