package leetcode;

/**
 * https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
 */
public class Problem1961 {
    public boolean isPrefixString(String s, String[] words) {
        String prefix1 = "";
        int prefix2Index = 0;
        for (String word : words) {
            prefix1 += word;
            if (prefix2Index + word.length() > s.length()) {
                return false;
            }
            String prefix2 = s.substring(0, prefix2Index + word.length());
            prefix2Index += word.length();
            if (!prefix1.equals(prefix2)) {
                return false;
            }
            if (prefix2.length() == s.length()) {
                return true;
            }
        }
        return false;
    }
}
