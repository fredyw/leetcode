package leetcode;

/**
 * https://leetcode.com/problems/break-a-palindrome/
 */
public class Problem1328 {
    public String breakPalindrome(String palindrome) {
        if (!isPalindrome(palindrome) || palindrome.length() == 1) {
            return "";
        }
        char[] answer = palindrome.toCharArray();
        boolean replaced = false;
        for (int i = 0; i < palindrome.length(); i++) {
            if (palindrome.length() % 2 != 0) {
                int mid = palindrome.length() / 2;
                if (palindrome.charAt(i) != 'a' && i != mid) {
                    answer[i] = 'a';
                    replaced = true;
                    break;
                }
            } else {
                if (palindrome.charAt(i) != 'a') {
                    answer[i] = 'a';
                    replaced = true;
                    break;
                }
            }
        }
        if (!replaced) {
            answer[answer.length - 1] = (char) (answer[answer.length - 1] + 1); // must be the last one
        }
        return new String(answer);
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
