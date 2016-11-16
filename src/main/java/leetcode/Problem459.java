package leetcode;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class Problem459 {
    public boolean repeatedSubstringPattern(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String sub = null;
            boolean found = true;
            int j = 0;
            for (; j + i <= str.length(); j += i) {
                String tmpSub = str.substring(j, j + i);
                if (sub == null) {
                    sub = tmpSub;
                } else {
                    if (!sub.equals(tmpSub)) {
                        found = false;
                        break;
                    }
                }
            }
            if (found && j == str.length()) {
                return true;
            }
        }
        return false;
    }
}
