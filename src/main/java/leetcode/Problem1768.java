package leetcode;

/**
 * https://leetcode.com/problems/merge-strings-alternately/
 */
public class Problem1768 {
    public String mergeAlternately(String word1, String word2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1768 prob = new Problem1768();
        System.out.println(prob.mergeAlternately("abc", "pqr")); // "apbqcr"
        System.out.println(prob.mergeAlternately("ab", "pqrs")); // "apbqrs"
        System.out.println(prob.mergeAlternately("abcd", "pq")); // "apbqcd"
    }
}
