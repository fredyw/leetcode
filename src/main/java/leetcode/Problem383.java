package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!charCount.containsKey(c)) {
                return false;
            }
            int count = charCount.get(c);
            int newCount = count - 1;
            if (newCount == 0) {
                charCount.remove(c);
            } else {
                charCount.put(c, newCount);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem383 prob = new Problem383();
        System.out.println(prob.canConstruct("a", "b")); // false
        System.out.println(prob.canConstruct("aa", "ab")); // false
        System.out.println(prob.canConstruct("aa", "aab")); // true
    }
}
