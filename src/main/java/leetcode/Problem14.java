package leetcode;

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        outer:
        while (true) {
            // scan vertically
            if (i >= strs[0].length()) {
                break;
            }
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String s = strs[j];
                if (i >= s.length()) {
                    break outer;
                }
                char c = s.charAt(i);
                if (c != tmp) {
                    break outer;
                }
            }
            result.append(tmp);
            i++;
        }
        return result.toString();
    }
}
