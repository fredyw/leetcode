package leetcode;

/**
 * https://leetcode.com/problems/thousand-separator/
 */
public class Problem1556 {
    public String thousandSeparator(int n) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1556 prob = new Problem1556();
        System.out.println(prob.thousandSeparator(987)); // "987"
        System.out.println(prob.thousandSeparator(1234)); // "1.234"
        System.out.println(prob.thousandSeparator(123456789)); // "123.456.789"
        System.out.println(prob.thousandSeparator(0)); // "0"
    }
}
