package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class Problem131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> accu = new ArrayList<>();
        partition(s, accu, result);
        return result; 
    }
    
    private void partition(String s, List<String> accu, List<List<String>> result) {
        if (s.length() == 0) {
            result.add(accu);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String leftSubstr = s.substring(0, i+1);
            if (!isPalindrome(leftSubstr)) {
                continue;
            } else {
                List<String> newAccu = new ArrayList<>(accu);
                newAccu.add(leftSubstr);
                String rightSubstr = s.substring(i+1);
                partition(rightSubstr, newAccu, result);
            }
        }
    }
    
    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
