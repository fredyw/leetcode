package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void partition(String s, int index, List<String> accu, List<List<String>> answer) {
        if (s.length() == index) {
            answer.add(new ArrayList<>(accu));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String a = s.substring(index, i + 1);
            if (isPalindrome(a)) {
                accu.add(a);
                partition(s, i + 1, accu, answer);
                accu.remove(accu.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
