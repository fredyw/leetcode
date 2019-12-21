package leetcode;

/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class Problem1234 {
    public int balancedString(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1234 prob = new Problem1234();
        System.out.println(prob.balancedString("QWER")); // 0
        System.out.println(prob.balancedString("QQWE")); // 1
        System.out.println(prob.balancedString("QQQW")); // 2
        System.out.println(prob.balancedString("QQQQ")); // 3
    }
}
