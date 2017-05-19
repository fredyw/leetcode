package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] counts1 = charCount(s1);
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            String sub = s2.substring(i, i + s1.length());
            int[] counts2 = charCount(sub);
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

    public static void main(String[] args) {
        Problem567 prob = new Problem567();
        System.out.println(prob.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(prob.checkInclusion("ab", "eidboaoo")); // false
        System.out.println(prob.checkInclusion("dinitrophenylhydrazine", "acetylphenylhydrazine")); // false
        System.out.println(prob.checkInclusion("adc", "dcda")); // true
    }
}
