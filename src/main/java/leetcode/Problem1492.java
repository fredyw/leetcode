package leetcode;

/**
 * https://leetcode.com/problems/the-kth-factor-of-n/
 */
public class Problem1492 {
    public int kthFactor(int n, int k) {
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                j++;
                if (j == k) {
                    return i;
                }
            }
        }
        return -1;
    }
}
