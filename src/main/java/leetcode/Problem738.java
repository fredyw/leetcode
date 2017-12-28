package leetcode;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 */
public class Problem738 {
    public int monotoneIncreasingDigits(int N) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem738 prob = new Problem738();
        System.out.println(prob.monotoneIncreasingDigits(10)); // 9
        System.out.println(prob.monotoneIncreasingDigits(1234)); // 1234
        System.out.println(prob.monotoneIncreasingDigits(332)); // 299
        System.out.println(prob.monotoneIncreasingDigits(1357)); // 1357
        System.out.println(prob.monotoneIncreasingDigits(9753)); // 8999
        System.out.println(prob.monotoneIncreasingDigits(9735)); // 8999
        System.out.println(prob.monotoneIncreasingDigits(999)); // 999
        System.out.println(prob.monotoneIncreasingDigits(555)); // 555
    }
}
