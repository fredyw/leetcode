package leetcode;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class Problem392 {
    public boolean isSubsequence(String s, String t) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem392 prob = new Problem392();
        System.out.println(prob.isSubsequence("ace", "abcde")); // true
        System.out.println(prob.isSubsequence("aec", "abcde")); // false
        System.out.println(prob.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(prob.isSubsequence("axc", "ahbgdc")); // false
    }
}
