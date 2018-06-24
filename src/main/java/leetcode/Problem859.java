package leetcode;

/**
 * https://leetcode.com/problems/buddy-strings/
 */
public class Problem859 {
    public boolean buddyStrings(String A, String B) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem859 prob = new Problem859();
        System.out.println(prob.buddyStrings("ab", "ba")); // true
        System.out.println(prob.buddyStrings("ab", "ab")); // false
        System.out.println(prob.buddyStrings("aa", "aa")); // true
        System.out.println(prob.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(prob.buddyStrings("", "aa")); // false
        System.out.println(prob.buddyStrings("abc", "cba")); // true
    }
}
