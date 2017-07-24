package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class Problem647 {
    public int countSubstrings(String s) {
        return countSubstrings(s, 0, s.length(), new boolean[s.length() + 1][s.length() + 1],
            new Integer[s.length() + 1][s.length() + 1]);
    }

    private static int countSubstrings(String s, int i, int j, boolean[][] processed, Integer memo[][]) {
        if (i >= j) {
            return 0;
        }
        String sub = s.substring(i, j);
        int count = 0;
        if (processed[i][j]) {
            return 0;
        }
//        if (memo[i][j] != null) {
//            return memo[i][j];
//        }
        if (isPalindrome(sub)) {
            processed[i][j] = true;
            count++;
        }
        int a = countSubstrings(s, i + 1, j, processed, memo);
        int b = countSubstrings(s, i, j - 1, processed, memo);
        int c = countSubstrings(s, i + 1, j - 1, processed, memo);
        count += a + b + c;
//        memo[i][j] = count;
        return count;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem647 prob = new Problem647();
//        System.out.println(prob.countSubstrings("abc")); // 3
//        System.out.println(prob.countSubstrings("abbc")); // 5
//        System.out.println(prob.countSubstrings("aaa")); // 6
        System.out.println(prob.countSubstrings("aaabbbccc")); // 18
        System.out.println(prob.countSubstrings("aabaa")); // 9
//        System.out.println(prob.countSubstrings("xkjkqlajprjwefilxgpdpebieswu")); // 30
    }
}
