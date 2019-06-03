package leetcode;

/**
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class Problem1071 {
    public String gcdOfStrings(String str1, String str2) {
        String s1 = str1.length() >= str2.length() ? str1 : str2;
        String s2 = str1.length() < str2.length() ? str1 : str2;
        if (s2.isEmpty()) {
            return str1;
        }
        int index = s1.indexOf(s2);
        if (index < 0) {
            return "";
        }
        String s3 = s1.substring(index + s2.length());
        return gcdOfStrings(s2, s3);
    }
}
