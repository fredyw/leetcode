package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/groups-of-special-equivalent-strings/
 */
public class Problem893 {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            String key = key(chars);
            set.add(key);
        }
        return set.size();
    }

    private static String key(char[] chars) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for (int j = 0; j < chars.length; j++) {
            if (j % 2 == 0) {
                even.append(chars[j]);
            } else {
                odd.append(chars[j]);
            }
        }
        char[] evenChars = even.toString().toCharArray();
        Arrays.sort(evenChars);
        String evenString = new String(evenChars);
        char[] oddChars = odd.toString().toCharArray();
        Arrays.sort(oddChars);
        String oddString = new String(oddChars);
        return evenString + "|" + oddString;
    }
}
