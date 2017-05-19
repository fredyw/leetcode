package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts1 = charCount(s1);
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] counts2 = charCount(s2.substring(0, s1.length()));
        if (Arrays.equals(counts1, counts2)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            // some optimization to not construct counts2
            counts2[s2.charAt(i - s1.length()) - 'a']--;
            counts2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(counts1, counts2)) {
                return true;
            }
        }
        return false;
    }

    private static int[] charCount(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        return counts;
    }
}
