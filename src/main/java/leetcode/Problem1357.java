package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/apply-discount-every-n-orders/
 */
public class Problem1357 {
    private static class Cashier {
        private final int n;
        private final int discount;
        private Map</* product= */ Integer, /* price= */ Integer> prices = new HashMap<>();
        private int count = 0;

        public Cashier(int n, int discount, int[] products, int[] prices) {
            this.n = n;
            this.discount = discount;
            for (int i = 0; i < products.length; i++) {
                this.prices.put(products[i], prices[i]);
            }
        }

        public double getBill(int[] product, int[] amount) {
            count++;
            double total = 0;
            for (int i = 0; i < product.length; i++) {
                double price = prices.get(product[i]);
                if (count % n == 0) {
                    price = price - ((price * discount) / 100);
                }
                total += price * amount[i];
            }
            return total;
        }
    }
}
