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
        StringBuilder sb = new StringBuilder();
        int idx = s.indexOf("@");
        sb.append(s.charAt(0));
        for (int i = 0; i < 4; i++) {
            sb.append("*");
        }
        sb.append(s.substring(idx - 1));
        return sb.toString();
    }

    private static String maskPhone(String s) {
        return "";
    }

    public static void main(String[] args) {
        Problem831 prob = new Problem831();
        System.out.println(prob.maskPII("LeetCode@LeetCode.com")); // l*****e@leetcode.com
        System.out.println(prob.maskPII("AB@qq.com")); // a*****b@qq.com
//        System.out.println(prob.maskPII("1(234)567-890")); // ***-***-7890
//        System.out.println(prob.maskPII("86-(10)12345678")); // +**-***-***-5678
//        System.out.println(prob.maskPII("1-(10)12345678")); // +*-***-***-5678
    }
}
