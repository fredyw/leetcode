package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class Problem438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int idx = p.charAt(i) - 'a';
            pArray[idx]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() > s.length()) {
                break;
            }
            int[] sArray = new int[26];
            for (int j = i; j < i + p.length(); j++) {
                int idx = s.charAt(j) - 'a';
                sArray[idx]++;
            }
            if (Arrays.equals(pArray, sArray)) {
                result.add(i);
            }
        }
        return result;
    }
}
