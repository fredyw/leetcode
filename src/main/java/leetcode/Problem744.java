package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class Problem744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, target);
        if (index >= 0) {
            index = (index + 1) % letters.length;
            while (letters[index] == target) {
                index = (index + 1) % letters.length;
            }
            return letters[index];
        }
        index = (-index - 1) % letters.length;
        return letters[index];
    }
}
