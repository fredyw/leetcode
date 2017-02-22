package leetcode;

/**
 * https://leetcode.com/problems/detect-capital/
 */
public class Problem520 {
    public boolean detectCapitalUse(String word) {

    }

    public static void main(String[] args) {
        Problem520 prob = new Problem520();
        System.out.println(prob.detectCapitalUse("USA")); // true
        System.out.println(prob.detectCapitalUse("leetcode")); // true
        System.out.println(prob.detectCapitalUse("Google")); // true
        System.out.println(prob.detectCapitalUse("ABc")); // false
        System.out.println(prob.detectCapitalUse("aBc")); // false
    }
}
