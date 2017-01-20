package leetcode;

/**
 * https://leetcode.com/problems/license-key-formatting/
 */
public class Problem482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        S = S.replaceAll("-", "");
        for (int i = S.length() - 1; i >= 0; i--) {
            sb.append(S.charAt(i));
            count++;
            if (count == K && i != 0) {
                sb.append('-');
                count = 0;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }
}
