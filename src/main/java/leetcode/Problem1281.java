package leetcode;

/**
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class Problem1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        for (char c : Integer.toString(n).toCharArray()) {
            product *= c - '0';
            sum += c - '0';
        }
        return product - sum;
    }
}
