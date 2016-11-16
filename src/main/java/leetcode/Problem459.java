package leetcode;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class Problem459 {
    public boolean repeatedSubstringPattern(String str) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem459 prob = new Problem459();
        System.out.println(prob.repeatedSubstringPattern("abab")); // true
        System.out.println(prob.repeatedSubstringPattern("aba")); // false
        System.out.println(prob.repeatedSubstringPattern("abcabcabcabc")); // true
    }
}
