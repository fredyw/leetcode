package leetcode;

/**
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class Problem58 {
    public int lengthOfLastWord(String s) {
        int idx = s.length()-1;
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        int lastWordLength = 0;
        for (int i = idx; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                idx = i;
                break;
            } else {
                lastWordLength++;
            }
        }
        return lastWordLength;
    }
}
