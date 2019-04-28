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
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < reversedWords.length; j++) {
                if (isPalindrome(words[i], reversedWords[j])) {
                    answer.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j], reversedWords[i])) {
                    answer.add(Arrays.asList(j, i));
                }
            }
        }
        return answer;
    }

    private static boolean isPalindrome(String word, String reversedWord) {
        if (word.equals(reversedWord)) {
            return true;
        }
        if (word.startsWith(reversedWord)) {
            String sub = word.substring(reversedWord.length());
            if (isPalindrome(sub)) {
                return true;
            }
        } else if (reversedWord.startsWith(word)) {
            String sub = reversedWord.substring(word.length());
            if (isPalindrome(sub)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
