package leetcode;

/**
 * https://leetcode.com/problems/construct-k-palindrome-strings/
 */
public class Problem1400 {
    public boolean canConstruct(String s, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1400 prob = new Problem1400();
        System.out.println(prob.canConstruct("annabelle", 2)); // true
        System.out.println(prob.canConstruct("leetcode", 3)); // false
        System.out.println(prob.canConstruct("true", 4)); // true
        System.out.println(prob.canConstruct("yzyzyzyzyzyzyzy", 2)); // true
        System.out.println(prob.canConstruct("cr", 7)); // false
    }
}
