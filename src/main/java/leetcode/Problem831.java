package leetcode;

/**
 * https://leetcode.com/problems/masking-personal-information/
 */
public class Problem831 {
    public String maskPII(String S) {
        if (isEmail(S)) {
            return maskEmail(S);
        }
        return maskPhone(S);
    }

    private static boolean isEmail(String s) {
        return s.contains("@");
    }

    private static String maskEmail(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int idx = s.indexOf("@");
        sb.append(s.charAt(0));
        for (int i = 0; i < 5; i++) {
            sb.append("*");
        }
        sb.append(s.substring(idx - 1));
        return sb.toString();
    }

    private static String maskPhone(String s) {
        s = s.replaceAll("\\(|\\)|-|\\+| ", "");
        StringBuilder sb = new StringBuilder();
        int countryCode = s.length() - 10;
        if (s.length() > 10) {
            sb.append("+");
            for (int i = 0; i < countryCode; i++) {
                sb.append("*");
            }
            sb.append("-");
        }
        sb.append("***-***-").append(s.substring(s.length() - 4));
        return sb.toString();
    }
}
