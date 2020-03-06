package leetcode;

/**
 * https://leetcode.com/problems/closest-divisors/
 */
public class Problem1362 {
    public int[] closestDivisors(int num) {
        int a = num + 1;
        int b = num + 2;
        int[] div1 = divisor(a);
        int diff1 = Math.abs(div1[0] - div1[1]);
        int[] div2 = divisor(b);
        int diff2 = Math.abs(div2[0] - div2[1]);
        return diff1 < diff2 ? div1 : div2;
    }

    private static int[] divisor(int num) {
        int[] div = new int[2];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int diff = Math.abs(i - (num / i));
                if (diff < min) {
                    div[0] = i;
                    div[1] = num / i;
                    min = diff;
                }
            }
        }
        return div;
    }
}
