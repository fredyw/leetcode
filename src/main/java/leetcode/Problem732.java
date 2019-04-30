package leetcode;

/**
 * https://leetcode.com/problems/my-calendar-iii/
 */
public class Problem732 {
    private static class MyCalendarThree {
        public MyCalendarThree() {
        }

        public int book(int start, int end) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        MyCalendarThree calendar = new MyCalendarThree();
        System.out.println(calendar.book(10, 20)); // 1
        System.out.println(calendar.book(50, 60)); // 1
        System.out.println(calendar.book(10, 40)); // 2
        System.out.println(calendar.book(5, 15)); // 3
        System.out.println(calendar.book(5, 10)); // 3
        System.out.println(calendar.book(25, 55)); // 3
    }
}
