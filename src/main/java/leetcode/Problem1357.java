package leetcode;

/**
 * https://leetcode.com/problems/apply-discount-every-n-orders/
 */
public class Problem1357 {
    private static class Cashier {
        public Cashier(int n, int discount, int[] products, int[] prices) {
            // TODO
        }

        public double getBill(int[] product, int[] amount) {
            // TODO
            return 0;
        }
    }

    public static void main(String[] args) {
        Cashier cashier = new Cashier(
            3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println(cashier.getBill(new int[]{1, 2}, new int[]{1, 2})); // 500
        System.out.println(cashier.getBill(new int[]{3, 7}, new int[]{10, 10})); // 4000
        System.out.println(cashier.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1})); // 800
        System.out.println(cashier.getBill(new int[]{4}, new int[]{10})); // 4000
        System.out.println(cashier.getBill(new int[]{7, 3}, new int[]{10, 10})); // 4000
        System.out.println(cashier.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7})); // 7350
        System.out.println(cashier.getBill(new int[]{2, 3, 5}, new int[]{5, 3, 2})); // 2500

    }
}
