package leetcode;

/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */
public class Problem1081 {
    public String smallestSubsequence(String text) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1081 prob = new Problem1081();
        System.out.println(prob.smallestSubsequence("cdadabcc")); // "adbc"
        System.out.println(prob.smallestSubsequence("abcd")); // "abcd"
        System.out.println(prob.smallestSubsequence("ecbacba")); // "eacb"
        System.out.println(prob.smallestSubsequence("leetcode")); // "letcod"
        System.out.println(prob.smallestSubsequence("acbabc")); // "abc"
    }
}
