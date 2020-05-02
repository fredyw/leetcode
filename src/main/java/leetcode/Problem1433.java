package leetcode;

/**
 * https://leetcode.com/problems/check-if-a-string-can-break-another-string/
 */
public class Problem1433 {
    public boolean checkIfCanBreak(String s1, String s2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1433 prob = new Problem1433();
        System.out.println(prob.checkIfCanBreak("abc", "xya")); // true
        System.out.println(prob.checkIfCanBreak("abe", "acd")); // false
        System.out.println(prob.checkIfCanBreak("leetcodee", "interview")); // true
    }
}
