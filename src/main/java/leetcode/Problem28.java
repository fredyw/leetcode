package leetcode;

/**
 * https://oj.leetcode.com/problems/implement-strstr/
 */
public class Problem28 {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        int idx = -1;
        for (int i = 0; i < haystack.length(); i++) {
            boolean found = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) {
                    return -1;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                idx = i;
                break;
            }
        }
        return idx;
    }
}
