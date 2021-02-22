package leetcode;

/**
 * https://leetcode.com/problems/longest-nice-substring/
 */
public class Problem1763 {
    public String longestNiceSubstring(String s) {
        StringBuilder answer = new StringBuilder();
        // TODO
        return answer.toString();
    }

    public static void main(String[] args) {
        Problem1763 prob = new Problem1763();
        System.out.println(prob.longestNiceSubstring("YazaAay")); // "aAa"
        System.out.println(prob.longestNiceSubstring("Bb")); // "Bb"
        System.out.println(prob.longestNiceSubstring("c")); // ""
        System.out.println(prob.longestNiceSubstring("dDzeE")); // "dD"
        System.out.println(prob.longestNiceSubstring("aBbA")); // "aBbA"
        System.out.println(prob.longestNiceSubstring("aBbAa")); // "aBbAa"
    }
}
