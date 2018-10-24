package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 */
public class Problem901 {
    private static class StockSpanner {
        private final Stack<PriceCount> stack = new Stack<>();

        private static class PriceCount {
            private final int price;
            private final int count;

            public PriceCount(int price, int count) {
                this.price = price;
                this.count = count;
            }
        }

        public StockSpanner() {
        }

        public int next(int price) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().price <= price) {
                count += stack.pop().count;
            }
            stack.push(new PriceCount(price, count));
            return count;
        }
    }
}
