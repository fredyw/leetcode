package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 */
public class Problem1643 {
    public int minimumDeletions(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1643 prob = new Problem1643();
        System.out.println(prob.minimumDeletions("aababbab")); // 2
        System.out.println(prob.minimumDeletions("bbaaaaabb")); // 2
        System.out.println(prob.minimumDeletions("bbbbbbbaaaaabb")); // 5
        System.out.println(prob.minimumDeletions("abbbbbbbbbbbb")); // 0
        System.out.println(prob.minimumDeletions("abab")); // 1
    }
}
