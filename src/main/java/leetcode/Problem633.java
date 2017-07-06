package leetcode;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class Problem633 {
    public boolean judgeSquareSum(int c) {
        for (int i = 1; i <= c / 2; i++) {
            double a = Math.sqrt(i);
            double b = Math.sqrt(c - i);
            if (a == (int) a && b == (int) b) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem633 prob = new Problem633();
        System.out.println(prob.judgeSquareSum(5)); // true
        System.out.println(prob.judgeSquareSum(3)); // false
        System.out.println(prob.judgeSquareSum(Integer.MAX_VALUE)); // false
    }
}
