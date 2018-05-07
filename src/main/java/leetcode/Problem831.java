package leetcode;

/**
 * https://leetcode.com/problems/masking-personal-information/
 */
public class Problem831 {
    public String maskPII(String S) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem831 prob = new Problem831();
        System.out.println(prob.maskPII("LeetCode@LeetCode.com")); // l*****e@leetcode.com
        System.out.println(prob.maskPII("AB@qq.com")); // a*****b@qq.com
        System.out.println(prob.maskPII("1(234)567-890")); // ***-***-7890
        System.out.println(prob.maskPII("86-(10)12345678")); // +**-***-***-5678
        System.out.println(prob.maskPII("1-(10)12345678")); // +*-***-***-5678
    }
}
