package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Problem242 {
    public boolean isAnagram(String s, String t) {
    	char[] sChars = s.toCharArray();
    	char[] tChars = t.toCharArray();
    	Arrays.sort(sChars);
    	Arrays.sort(tChars);
    	return Arrays.equals(sChars, tChars);
    }
}
