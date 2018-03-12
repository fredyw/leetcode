package leetcode;

/**
 * https://leetcode.com/problems/rotate-string/
 */
public class Problem796 {
    public boolean rotateString(String A, String B) {
        for (int x = 0; x < B.length(); x++) {
            if (B.charAt(x) == A.charAt(0)) {
                boolean found = true;
                for (int i = 0, j = x; i < A.length(); i++, j++) {
                    if (j == B.length()) {
                        j = 0;
                    }
                    if (A.charAt(i) != B.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }
}
