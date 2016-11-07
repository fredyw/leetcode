package leetcode;

/**
 * https://leetcode.com/problems/arranging-coins/
 */
public class Problem441 {
    public int arrangeCoins(int n) {
        long sum = 0;
        int result = 0;
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            sum += i;
            if (n < sum) {
                break;
            }
            result++;
        }
        return result;
    }
}
