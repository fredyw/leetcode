package leetcode;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */
public class Problem1461 {
    public boolean hasAllCodes(String s, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1461 prob = new Problem1461();
        System.out.println(prob.hasAllCodes("00110110", 2)); // true
        System.out.println(prob.hasAllCodes("00110", 2)); // true
        System.out.println(prob.hasAllCodes("0110", 1)); // true
        System.out.println(prob.hasAllCodes("0110", 2)); // false
        System.out.println(prob.hasAllCodes("0000000001011100", 4)); // false
    }
}
