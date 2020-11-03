package leetcode;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 */
public class Problem1638 {
    public int countSubstrings(String s, String t) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1638 prob = new Problem1638();
        System.out.println(prob.countSubstrings("aba", "baba")); // 6
        System.out.println(prob.countSubstrings("ab", "bb")); // 3
        System.out.println(prob.countSubstrings("a", "a")); // 0
        System.out.println(prob.countSubstrings("abe", "bbc")); // 10
        System.out.println(prob.countSubstrings("computer", "computation")); // 90
    }
}
