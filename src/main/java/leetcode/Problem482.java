package leetcode;

/**
 * https://leetcode.com/problems/license-key-formatting/
 */
public class Problem482 {
    public String licenseKeyFormatting(String S, int K) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem482 prob = new Problem482();
        System.out.println(prob.licenseKeyFormatting("2-4A0r7-4k", 4)); // 24A0-R74K
        System.out.println(prob.licenseKeyFormatting("2-4A0r7-4k", 3)); // 24-A0R-74K
    }
}
