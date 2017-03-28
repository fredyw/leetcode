package leetcode;

/**
 * https://leetcode.com/problems/perfect-number/
 */
public class Problem507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (i == 1) {
                sum += i;
            } else {
                // find the divisor
                if (num % i == 0) {
                    sum += i;
                    sum += num / i;
                }
            }
        }
        return (sum == num);
    }
}
