package leetcode;

/**
 * https://leetcode.com/problems/reverse-string-ii/
 */
public class Problem541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        if (k >= s.length()) {
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }
        boolean reverse = true;
        int i = 0;
        for (; i < s.length(); i += k) {
            if (reverse) {
                if (i + k - 1 < s.length()) {
                    for (int j = i + k - 1; j >= i; j--) {
                        sb.append(s.charAt(j));
                    }
                }
            } else {
                for (int j = i; j < i + k && j < s.length(); j++) {
                    sb.append(s.charAt(j));
                }
            }
            if (i + k >= s.length()) {
                break;
            }
            reverse = !reverse;
        }
        String result = sb.toString();
        if (s.length() > result.length()) {
            if (reverse) {
                for (int j = s.length() - 1; j >= i; j--) {
                    sb.append(s.charAt(j));
                }
            } else {
                i -= k;
                for (; i < s.length(); i++) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
