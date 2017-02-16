package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        return longestPalindromSubsequence(s, 0, "", new HashMap<>());
    }

    private static int longestPalindromSubsequence(String str, int idx, String accu,
                                                   Map<String, Integer> memo) {
        if (idx == str.length()) {
            if (isPalindrome(accu)) {
                return accu.length();
            }
            return 0;
        }
        String key = idx + "|" + accu;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        if (isPalindrome(accu)) {
            max = accu.length();
        }
        int a = longestPalindromSubsequence(str, idx + 1, accu, memo);
        int b = longestPalindromSubsequence(str, idx + 1, accu + str.charAt(idx), memo);
        max = Math.max(max, Math.max(a, b));
        memo.put(key, max);
        return max;
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem516 prob = new Problem516();
//        System.out.println(prob.longestPalindromeSubseq("bbbab")); // 4
//        System.out.println(prob.longestPalindromeSubseq("cbbd")); // 2
//        System.out.println(prob.longestPalindromeSubseq("abacadae")); // 5
        System.out.println(prob.longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew")); // 159
    }
}
