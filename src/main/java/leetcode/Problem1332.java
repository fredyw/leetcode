package leetcode;

/**
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */
public class Problem1332 {
    public int removePalindromeSub(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1332 prob = new Problem1332();
        System.out.println(prob.removePalindromeSub("ababa")); // 1
        System.out.println(prob.removePalindromeSub("abb")); // 2
        System.out.println(prob.removePalindromeSub("baabb")); // 2
        System.out.println(prob.removePalindromeSub("")); // 0
    }
}
