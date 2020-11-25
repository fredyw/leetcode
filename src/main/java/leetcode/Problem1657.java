package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
public class Problem1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        boolean[] chars1 = new boolean[26];
        boolean[] chars2 = new boolean[26];
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            chars1[word1.charAt(i) - 'a'] = true;
            chars2[word2.charAt(i) - 'a'] = true;
            counts1[word1.charAt(i) - 'a']++;
            counts2[word2.charAt(i) - 'a']++;
        }
        if (!Arrays.equals(chars1, chars2)) {
            return false;
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        return Arrays.equals(counts1, counts2);
    }
}
