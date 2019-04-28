package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class Problem336 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    answer.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j] + words[i])) {
                    answer.add(Arrays.asList(j, i));
                }
            }
        }
        return answer;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem336 prob = new Problem336();
        System.out.println(prob.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})); // [[0,1],[1,0],[3,2],[2,4]]
        System.out.println(prob.palindromePairs(new String[]{"bat", "tab", "cat"})); // [[0,1],[1,0]]
    }
}
