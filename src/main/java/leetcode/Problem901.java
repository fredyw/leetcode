package leetcode;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class Problem901 {
    private static class StockSpanner {
        public StockSpanner() {
        }

        public int next(int price) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
//        System.out.println(spanner.next(100)); // 1
//        System.out.println(spanner.next(80)); // 1
//        System.out.println(spanner.next(60)); // 1
//        System.out.println(spanner.next(70)); // 2
//        System.out.println(spanner.next(60)); // 1
//        System.out.println(spanner.next(75)); // 4
//        System.out.println(spanner.next(85)); // 6

        System.out.println(spanner.next(1)); // 1
        System.out.println(spanner.next(1)); // 2
        System.out.println(spanner.next(1)); // 3
        System.out.println(spanner.next(1)); // 4
        System.out.println(spanner.next(10)); // 5
        System.out.println(spanner.next(20)); // 6
        System.out.println(spanner.next(0)); // 1
    }
}
