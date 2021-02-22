package leetcode;

/**
 * https://leetcode.com/problems/longest-nice-substring/
 */
public class Problem1763 {
    public String longestNiceSubstring(String s) {
        return getLongestNiceSubstring(s).string;
    }

    private static class NiceString {
        private final String string;
        private final boolean nice;

        public NiceString(String string, boolean nice) {
            this.string = string;
            this.nice = nice;
        }
    }

    private static NiceString getLongestNiceSubstring(String s) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upper[c - 'A'] = true;
            } else {
                lower[c - 'a'] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((Character.isUpperCase(c) && !lower[c - 'A']) ||
                (Character.isLowerCase(c) && !upper[c - 'a'])) {
                NiceString ns1 = getLongestNiceSubstring(s.substring(0, i));
                NiceString ns2 = getLongestNiceSubstring(s.substring(i + 1));
                if (ns1.nice && ns2.nice) {
                    if (ns1.string.length() >= ns2.string.length()) {
                        return new NiceString(ns1.string, true);
                    } else {
                        return new NiceString(ns2.string, true);
                    }
                } else if (ns1.nice) {
                    return ns1;
                } else if (ns2.nice) {
                    return ns2;
                }
                return new NiceString("", false);
            }
        }
        return new NiceString(s, true);
    }
}
