package leetcode;

/**
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class Problem647 {
    public int countSubstrings(String s) {
        return countSubstrings(s, 0, s.length());
    }

    private static int countSubstrings(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        String sub = s.substring(i, j);
        int count = 0;
        if (isPalindrome(sub)) {
            count++;
        }
        int a = countSubstrings(s, i + 1, j);
        int b = countSubstrings(s, i, j - 1);
        int c = countSubstrings(s, i + 1, j - 1);
        return count + a + b + c;
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
        System.out.println(prob.countSubstrings("abc")); // 3
//        System.out.println(prob.countSubstrings("aaa")); // 6
    }
}
