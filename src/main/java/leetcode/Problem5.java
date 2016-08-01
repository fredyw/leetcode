package leetcode;

/**
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String longest = "";
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String p = palindrome(chars, i, true);
            if (p.length() > longest.length()) {
                longest = p;
            }
            p = palindrome(chars, i, false);
            if (p.length() > longest.length()) {
                longest = p;
            }
        }
        return longest;
    }

    private String palindrome(char[] chars, int idx, boolean even) {
        int left = idx;
        int right = idx;
        if (!even) {
            if (idx - 1 >= 0 && idx + 1 < chars.length && chars[idx - 1] == chars[idx + 1]) {
                left--;
                right++;
            } else if (idx + 1 < chars.length && chars[idx] == chars[idx + 1]) {
                right++;
            } else {
                return "";
            }
        } else {
            if (idx + 1 < chars.length && chars[idx] == chars[idx + 1]) {
                right++;
            } else if (idx - 1 >= 0 && idx + 1 < chars.length && chars[idx - 1] == chars[idx + 1]) {
                left--;
                right++;
            } else {
                return "";
            }
        }
        while (left >= 0 && right < chars.length) {
            if (chars[left] != chars[right]) {
                break;
            }
            left--;
            right++;
        }
        left++;
        right--;
        return new String(chars, left, right - left + 1);
    }
}
