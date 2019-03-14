package leetcode;

/**
 * https://leetcode.com/problems/decoded-string-at-index/
 */
public class Problem880 {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                size++;
            } else {
                size *= S.charAt(i) - '0';
            }
        }
        int k = K;
        for (int i = S.length() - 1; i >= 0; i--) {
            k %= size;
            if (k == 0 && S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                return "" + S.charAt(i);
            }

            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                size--;
            } else {
                size /= S.charAt(i) - '0';
            }
        }
        return "";
    }
}
