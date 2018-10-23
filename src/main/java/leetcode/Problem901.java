package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class Problem901 {
    private static class StockSpanner {
        private final Stack<Integer> stack = new Stack<>();

        public StockSpanner() {
        }

        public int next(int price) {
            int count = 1;
            Stack<Integer> tmp = new Stack<>();
            tmp.add(price);
            while (!stack.isEmpty()) {
                Integer val = stack.pop();
                if (val <= price) {
                    tmp.add(val);
                    count++;
                } else {
                    tmp.add(val);
                    break;
                }
            }

            while (!tmp.isEmpty()) {
                stack.add(tmp.pop());
            }
            return count;
        }
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100)); // 1
        System.out.println(spanner.next(80)); // 1
        System.out.println(spanner.next(60)); // 1
        System.out.println(spanner.next(70)); // 2
        System.out.println(spanner.next(60)); // 1
        System.out.println(spanner.next(75)); // 4
        System.out.println(spanner.next(85)); // 6
    }
}
