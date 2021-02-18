package leetcode;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class Problem1758 {
    public int minOperations(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1758 prob = new Problem1758();
        System.out.println(prob.minOperations("0100")); // 1
        System.out.println(prob.minOperations("10")); // 0
        System.out.println(prob.minOperations("1111")); // 2
    }
}
