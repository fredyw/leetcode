package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class Problem1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String s1 = Arrays.stream(word1).collect(Collectors.joining(""));
        String s2 = Arrays.stream(word2).collect(Collectors.joining(""));
        return s1.equals(s2);
    }
}
